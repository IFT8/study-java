package com.comodin.basic.util;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Common util.
 */
public class CommonUtil {
    /**
     * logger
     */
    private static final Logger log = Logger.getLogger(CommonUtil.class);
    /**
     * 打印audit的日志, type是数据的类型，比如username、token、ip。。。；value对应的值
     */
    private static final Logger auditLogger = Logger.getLogger("com.comodin.audit");

    /**
     * 本机ip地址
     */
    private static String localIp = null;

    /**
     * audit日志  以下不要轻音修改
     */
    public static final String AUDIT_LOG_REQUEST_ID = "req_id";
    public static final String AUDIT_LOG_LOCAL_IP = "local_ip";
    public static final String AUDIT_LOG_REMOTE_IP = "remote_ip";
    public static final String AUDIT_LOG_TIMESTAMP = "req_start";
    public static final String AUDIT_LOG_PARAMS = "req_params";
    public static final String AUDIT_LOG_REQ_URI = "req_uri";
    public static final String AUDIT_LOG_REQ_METHOD = "req_method";
    public static final String AUDIT_LOG_CHECK_AUTH = "req_auth";
    public static final String AUDIT_LOG_AUTH_REASON = "req_auth_reason";

    /**
     * 获取本机ip地址，主要是记录日志或本机信息相关的时候用
     *
     * @return local server ip
     */
    public static String getLocalServerIp() {
        if (localIp == null) {
            InetAddress addr;
            try {
                addr = InetAddress.getLocalHost();
                localIp = addr.getHostAddress();
            } catch (UnknownHostException e) {
                log.error("get local server address error", e);
            }
        }
        return localIp;
    }

    /**
     * Log for audit.
     *
     * @param request the request
     * @param type    the type
     * @param value   the value
     */
    public static void logForAudit(HttpServletRequest request, String type, String value) {
        String reqId = (String) request.getAttribute(AUDIT_LOG_REQUEST_ID);
        //如果reqId不存在就生成一个
        if (reqId == null) {
            reqId = UUID.randomUUID().toString();
            reqId.replaceAll("-", "");
            request.setAttribute(AUDIT_LOG_REQUEST_ID, reqId);
        }
        StringBuffer sb = new StringBuffer();
        sb.append(reqId);
        sb.append(" # ");
        sb.append(type);
        sb.append(" # ");
        sb.append(value);
        auditLogger.info(sb.toString());
    }

    /**
     * 如果取不到request对象，就直接传reqId
     *
     * @param reqID the req id
     * @param type  the type
     * @param value the value
     */
    public static void logForAudit(String reqID, String type, String value) {

        StringBuffer sb = new StringBuffer();
        sb.append(reqID);
        sb.append(" # ");
        sb.append(type);
        sb.append(" # ");
        sb.append(value);
        auditLogger.info(sb.toString());
    }

    /**
     * Gets remote ip.
     *
     * @param request the request
     *
     * @return the remote ip
     */
    public static String getRemoteIp(HttpServletRequest request) {
        String ipAddress = null;
        // ipAddress = this.getRequest().getRemoteAddr();
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0
                || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


    /**
     * 判断字符串是否符合正则表达式
     *
     * @param regExp the reg exp
     * @param args   the args
     *
     * @return boolean
     */
    public static boolean regExpMatch(String regExp, String args) {

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(args);
        return matcher.matches();
    }

    /**
     * 取出第一个符合正则表达式的字符串
     *
     * @param regExp the reg exp
     * @param args   the args
     *
     * @return string
     */
    public static String regExpFindMatch(String regExp, String args) {

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(args);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }


    /**
     * 判断字符串是否为空
     *
     * @param str the str
     *
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0 || str.trim().equals("")
                || str.trim().equals("null")) {
            return true;
        }
        return false;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     *
     * @return 转化出来的  Map 对象
     *
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Map convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }


    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param type 要转化的类型
     * @param map  包含属性值的 map
     *
     * @return 转化出来的 JavaBean 对象
     *
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InstantiationException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings("rawtypes")
    public static Object convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性  
        Object obj = type.newInstance(); // 创建 JavaBean 对象  

        // 给 JavaBean 对象的属性赋值  
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。  
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /*** 
     * 利用反射设置对象的属性值. 注意:属性可以没有setter 方法. 
     *
     * @param obj
     * @param params
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setObjectValue(Object obj, Map<String, Object> params)
            throws SecurityException,
            IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        if (obj == null) {
            return;
        }
        Class<?> clazz = obj.getClass();
        for (Iterator<?> it = params.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            String key = entry.getKey();
            Object propertyValue = entry.getValue();
            if (propertyValue == null) {
                continue;
            }
            Field name = getSpecifiedField(clazz, key);
            if (name != null) {
                name.setAccessible(true);
                name.set(obj, propertyValue);
            }
        }

    }

    private static Field getSpecifiedField(Class<?> clazz, String key) {
        try {
            return clazz.getDeclaredField(key);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String value = "/kkxins122g.php";
        //String regExp = "^/([a-zA-Z0-9]+)\\.php$";
        String regExp = "^/([a-zA-Z0-9]+)\\.php$";

        String result = regExpFindMatch(regExp, value);
        System.out.println(result);
    }
}
