package com.comodin.basic.interceptors;

import com.comodin.basic.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.UUID;


/**
 * <pre>
 * SpringMVC 中的Interceptor 拦截请求是通过HandlerInterceptor 来实现的
 *      主要有两种方式，
 *          实现了Spring的 HandlerInterceptor 接口，
 *          或是 继承实现了HandlerInterceptor接口的类【实现了HandlerInterceptor 接口的抽象类 HandlerInterceptorAdapter】
 *      preHandle
 *          方法是进行处理器拦截用的，顾名思义，
 *          该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在 Controller方法调用之前调用。
 *          SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返回值为false，当preHandle的返回值为false的时候整个请求就结束了。
 *
 *      postHandle
 *          这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。
 *          postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之后，也就是在Controller的方法调用之后执行，
 *          但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操作。
 *          这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
 *              只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
 *              或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
 *      afterCompletion
 *          该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。
 *              该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
 *              这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
 *
 *  性能监控
 *      如记录一下请求的处理时间，得到一些慢请求（如处理时间超过500毫秒），从而进行性能改进，一般的反向代理服务器如apache都具有这个功能，但此处我们演示一下使用拦截器怎么实现。
 *
 *      实现分析：
 *          1、在进入处理器之前记录开始时间，即在拦截器的preHandle记录开始时间；
 *          2、在结束请求处理之后记录结束时间，即在拦截器的afterCompletion记录结束实现，并用结束时间-开始时间得到这次请求的处理时间。
 *      问题：
 *          我们的拦截器是单例，因此不管用户请求多少次都只有一个拦截器实现，即线程不安全，那我们应该怎么记录时间呢？
 *          解决方案是使用ThreadLocal，它是线程绑定的变量，提供线程局部变量（一个线程一个ThreadLocal，A线程的ThreadLocal只能看到A线程的ThreadLocal，不能看到B线程的ThreadLocal）。
 *
 *      在测试时需要把 Interceptor 放在拦截器链的第一个，这样得到的时间才是比较准确的。
 * </pre>
 */
public class APMInterceptor implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger("com.comodin.apm");

    private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");  //NamedThreadLocal：Spring提供的一个命名的ThreadLocal实现。

    private static final String APM_INTERCEPTOR_REQUEST_ID = "APMInterceptorRequestId";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(APM_INTERCEPTOR_REQUEST_ID, UUID.randomUUID().toString().replaceAll("-", ""));
        if (log.isDebugEnabled()) {
            long beginTime = System.currentTimeMillis();    //1、开始时间
            startTimeThreadLocal.set(beginTime);            //线程绑定变量（该数据只有当前请求的线程可见）
            log.info(getInfoPrefix(request) + " # start_timer: " + new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime));
        }
        return true;        //继续流程
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.info(getInfoPrefix(request) + " # ModelAndView: " + ((modelAndView != null) ? modelAndView.getViewName() : null));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 打印JVM信息。
        if (log.isDebugEnabled()) {
            long beginTime = startTimeThreadLocal.get();    //得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();      //2、结束时间
            long consumeTime = endTime - beginTime;         //3、消耗的时间
            if (log.isDebugEnabled()) {
                log.info(getInfoPrefix(request) + " # end_timer: " + new SimpleDateFormat("hh:mm:ss.SSS").format(endTime));
            }
            String timeStr = String.format(" # use_timer: %s # start_timer: %s # end_timer: %s ", consumeTime, new SimpleDateFormat("hh:mm:ss.SSS").format(beginTime), new SimpleDateFormat("hh:mm:ss.SSS").format(endTime));
            String memoryStr = String.format(" # memory total: {%s}m  used: {%s}m used free space: {%s}m  free: {%s}m",
                    Runtime.getRuntime().maxMemory() / 1024 / 1024, //total
                    Runtime.getRuntime().totalMemory() / 1024 / 1024,//used
                    Runtime.getRuntime().freeMemory() / 1024 / 1024,//used free space
                    ((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024)//free
            );
            if (log.isDebugEnabled()) {
                if (consumeTime > 500) {//此处认为处理时间超过500毫秒的请求为慢请求
                    log.error(this.getInfoPrefix(request) + timeStr + memoryStr);
                } else {
                    log.info(this.getInfoPrefix(request) + timeStr + memoryStr);
                }
            }
        }
    }

    private String getInfoPrefix(HttpServletRequest request) {
        String reqId = (String) request.getAttribute(APM_INTERCEPTOR_REQUEST_ID);
        //如果reqId不存在就生成一个
        if (reqId == null) {
            request.setAttribute(APM_INTERCEPTOR_REQUEST_ID, UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return String.format("requestId: %s # remote_ip: %s # req_uri: %s # req_method: %s", reqId, CommonUtil.getRemoteIp(request), request.getRequestURI(), request.getMethod());
    }
}
