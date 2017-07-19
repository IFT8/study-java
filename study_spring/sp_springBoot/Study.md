17、web 三

拦截器的使用步骤
1、写一个拦截器，实现 HandlerInterceptor 接口

    执行 Controller 之前调用
    boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
    
    执行 Controller 之后，且页面渲染之前调用
    void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception;
    
    页面渲染之后调用，一般用于资源清理操作        			
    void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception;

2、写一个类，继承 WebMvcConfigurerAdapter，然后重写 void addInterceptors(InterceptorRegistry registry) {} 方法；通过 registry 将刚才写的拦截器类，增加进去。

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogHandlerInterceptor());
    }


