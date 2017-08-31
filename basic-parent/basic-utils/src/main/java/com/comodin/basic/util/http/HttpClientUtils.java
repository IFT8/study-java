package com.comodin.basic.util.http;

import com.comodin.basic.util.logger.AuditLogsUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * //log.info(" ==> Server Request: GET	---URL:    " + url);
 * //log.info(" ==> Server Params : ");
 * //log.info(" <== Server Result: " + responseResult);
 * <p>
 * //log.info(" ==> Server Request: POST	---URL:    " + url);
 * //log.info(" ==> Server Params: " + JSON.toJSONString(paramMap));
 * //log.info(" <== Server Result: " + responseResult);
 */
@SuppressWarnings({"Duplicates", "WeakerAccess", "unused", "Convert2Diamond"})
public class HttpClientUtils {

    // set Timeout
    private static final RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(500000).setConnectTimeout(50000).setSocketTimeout(50000).build();

    private static String serverResultInfoAll = "" +
            "\n\t===>>>Server Request Address: %s\t%s" +
            "\n\t===>>>Server Request Headers: %s" +
            "\n\t===>>>Server Request Params : %s" +
            "\n\t<<<===Server Return  Status : %s" +
            "\n\t<<<===Server Return  Result : %s" +
            "\n";

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url 请求的URL地址
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url) throws IOException, URISyntaxException {
        return getRequest(url, Consts.UTF_8.toString(), new HashMap<String, String>(), new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url 请求的URL地址
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, boolean whetherPrintResult) throws IOException, URISyntaxException {
        return getRequest(url, Consts.UTF_8.toString(), new HashMap<String, String>(), new HashMap<String, String>(), whetherPrintResult);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, String contentEncoding) throws IOException, URISyntaxException {
        return getRequest(url, contentEncoding, new HashMap<String, String>(), new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url      请求的URL地址
     * @param paramMap 请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, Map<String, String> paramMap) throws IOException, URISyntaxException {
        return getRequest(url, Consts.UTF_8.toString(), paramMap, new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, String contentEncoding, Map<String, String> paramMap) throws IOException, URISyntaxException {
        return getRequest(url, contentEncoding, paramMap, new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url       请求的URL地址
     * @param paramMap  请求参数
     * @param headerMap 请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, Map<String, String> paramMap, Map<String, String> headerMap) throws IOException, URISyntaxException {
        return getRequest(url, Consts.UTF_8.toString(), paramMap, headerMap, true);
    }

    public static String getRequest(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap) throws URISyntaxException, IOException {
        return getRequest(url, contentEncoding, paramMap, headerMap, true);
    }

    /**
     * <pre>
     *          业务功能：get 请求
     *          // by:supeng date:2017-08-26 23:32:22
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     * @param headerMap       请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws URISyntaxException //
     * @throws IOException        //
     */
    public static String getRequest(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap, boolean whetherPrintResult) throws URISyntaxException, IOException {
        paramMap = paramMap == null ? new HashMap<String, String>() : paramMap;
        headerMap = headerMap == null ? new HashMap<String, String>() : headerMap;

        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();

            //1、拼装、请求头信息
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            // 2、拼装，请求参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }


            // 3、初始化
            // 3.1、组装参数，设置传送数据类型为
            URIBuilder uriBuilder = new URIBuilder(url).setCharset(Charset.forName(contentEncoding));
            if (!params.isEmpty()) {
                uriBuilder.setParameters(params);
            }
            HttpRequestBase httpRequestBase = new HttpGet(uriBuilder.build());
            httpRequestBase.setConfig(requestConfig);
            // 3.2、组装请求头
            httpRequestBase.setHeaders(headers.toArray(new Header[headers.size()]));


            for (NameValuePair nameValuePair : uriBuilder.getQueryParams()) {
                paramMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            return httpClient.execute(httpRequestBase, processHttpResponseResult(httpRequestBase, contentEncoding, paramMap, headerMap, whetherPrintResult));
        } catch (URISyntaxException e) {
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(String.format("syntax url fail. %s", e.getMessage()), e);
            throw e;
        } catch (IOException e) {
            String msg = String.format(serverResultInfoAll, "GET", url, HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), "ERROR", e.getMessage());
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg, e);
            throw e;
        } finally {
            HttpClientUtils.closeResources(httpClient, null);
        }
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url      请求的URL地址
     * @param paramMap 请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postForm(String url, Map<String, String> paramMap) throws IOException {
        return postForm(url, Consts.UTF_8.toString(), paramMap, new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postForm(String url, String contentEncoding, Map<String, String> paramMap) throws IOException {
        return postForm(url, contentEncoding, paramMap, new HashMap<String, String>(), true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url       请求的URL地址
     * @param paramMap  请求参数
     * @param headerMap 请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postForm(String url, Map<String, String> paramMap, Map<String, String> headerMap) throws IOException {
        return postForm(url, Consts.UTF_8.toString(), paramMap, headerMap, true);
    }

    public static String postForm(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap) throws IOException {
        return postForm(url, contentEncoding, paramMap, headerMap, true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     * @param headerMap       请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postForm(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap, boolean whetherPrintResult) throws IOException {
        if (paramMap == null || paramMap.isEmpty()) {
            throw new RuntimeException("paramMap is null");
        }
        headerMap = headerMap == null ? new HashMap<String, String>() : headerMap;

        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();

            //1、拼装、请求头信息
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            // 2、拼装，请求参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 3、初始化
            HttpEntityEnclosingRequestBase httpRequestBase = new HttpPost(url);
            httpRequestBase.setConfig(requestConfig);
            // 3.1、组装参数，设置传送数据类型为
            if (!params.isEmpty()) {
                httpRequestBase.setEntity(new UrlEncodedFormEntity(params, contentEncoding));
            }
            // 3.2、组装请求头
            httpRequestBase.setHeaders(headers.toArray(new Header[headers.size()]));

            return httpClient.execute(httpRequestBase, processHttpResponseResult(httpRequestBase, contentEncoding, paramMap, headerMap, whetherPrintResult));
        } catch (IOException e) {
            String msg = String.format(serverResultInfoAll, "POST", url, HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), "ERROR", e.getMessage());
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg, e);
            throw e;
        } finally {
            HttpClientUtils.closeResources(httpClient, null);
        }
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单，带附件方式
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url      请求的URL地址
     * @param paramMap 请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postFormMultipart(String url, Map<String, ?> paramMap) throws IOException {
        return postFormMultipart(url, Consts.UTF_8.toString(), paramMap, null, true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单，带附件方式
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postFormMultipart(String url, String contentEncoding, Map<String, ?> paramMap) throws IOException {
        return postFormMultipart(url, contentEncoding, paramMap, null, true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单，带附件方式
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url       请求的URL地址
     * @param paramMap  请求参数
     * @param headerMap 请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postFormMultipart(String url, Map<String, ?> paramMap, Map<String, String> headerMap) throws IOException {
        return postFormMultipart(url, Consts.UTF_8.toString(), paramMap, headerMap, true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单，带附件方式
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     * @param headerMap       请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postFormMultipart(String url, String contentEncoding, Map<String, ?> paramMap, Map<String, String> headerMap) throws IOException {
        return postFormMultipart(url, contentEncoding, paramMap, headerMap, true);
    }

    /**
     * <pre>
     *          业务功能：post方式提交 from表单，带附件方式
     *          // by:supeng date:2017-08-26 23:33:51
     * </pre>
     *
     * @param url             请求的URL地址
     * @param contentEncoding 编码
     * @param paramMap        请求参数
     * @param headerMap       请求头
     *
     * @return 返回，服务器，结果
     *
     * @throws IOException //
     */
    public static String postFormMultipart(String url, String contentEncoding, Map<String, ?> paramMap, Map<String, String> headerMap, boolean whetherPrintResult) throws IOException {
        if (paramMap == null || paramMap.isEmpty()) {
            throw new RuntimeException("paramMap is null");
        }
        headerMap = headerMap == null ? new HashMap<String, String>() : headerMap;

        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();

            //1、拼装、请求头信息
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            // 2、拼装，请求参数
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            Map<String, String> logStrParamMap = new HashMap<String, String>();
            for (Map.Entry<String, ?> entry : paramMap.entrySet()) {
                String paramName = entry.getKey();
                Object paramValue = entry.getValue();
                if (paramValue instanceof String) {
                    String value = String.valueOf(paramValue);
                    multipartEntityBuilder.addTextBody(paramName, value, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), contentEncoding));
                    logStrParamMap.put(paramName, String.valueOf(paramValue));
                } else if (paramValue instanceof File) {
                    File file = (File) paramValue;
                    multipartEntityBuilder.addBinaryBody(paramName, file, ContentType.MULTIPART_FORM_DATA, file.getPath());
                    logStrParamMap.put(paramName, file.toString());
                } else if (paramValue instanceof InputStream) {
                    InputStream inputStream = (InputStream) paramValue;
                    multipartEntityBuilder.addBinaryBody(paramName, inputStream, ContentType.MULTIPART_FORM_DATA, "file inputStream");
                    logStrParamMap.put(paramName, "inputStream");
                } else {
                    throw new RuntimeException("postFormMultipart form data type:[String,File,InputStream] " +
                            "current param name:[" + paramName + "] of param value type: [" + paramValue.getClass().getName() + "]");
                }
            }


            // 3、初始化
            HttpEntityEnclosingRequestBase httpRequestBase = new HttpPost(url);
            httpRequestBase.setConfig(requestConfig);
            // 3.1、组装参数，设置传送数据类型为
            httpRequestBase.setEntity(multipartEntityBuilder.build());
            // 3.2、组装请求头
            httpRequestBase.setHeaders(headers.toArray(new Header[headers.size()]));

            return httpClient.execute(httpRequestBase, processHttpResponseResult(httpRequestBase, contentEncoding, logStrParamMap, headerMap, whetherPrintResult));

        } catch (IOException e) {
            String msg = String.format(serverResultInfoAll, "POST", url, HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), "ERROR", e.getMessage());
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg, e);
            throw e;
        } finally {
            HttpClientUtils.closeResources(httpClient, null);
        }
    }


    /**
     * <pre>
     *          业务功能：内部集中处理，结果
     *          // by:supeng date:2017-08-26 23:37:48
     * </pre>
     *
     * @param httpRequestBase    //
     * @param contentEncoding    编码
     * @param paramMap           请求参数
     * @param headerMap          请求头
     * @param whetherPrintResult //是否打印，result
     *
     * @return 返回，服务器，结果
     */
    private static ResponseHandler<String> processHttpResponseResult(HttpRequestBase httpRequestBase, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap, boolean whetherPrintResult) {
        return response -> {
            String responseResult = (response.getEntity() != null) ? EntityUtils.toString(response.getEntity(), contentEncoding) : "";
            int statusCode = response.getStatusLine().getStatusCode();

            String msg = String.format(serverResultInfoAll, httpRequestBase.getMethod(), httpRequestBase.getURI(), HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), statusCode, whetherPrintResult ? HttpClientUtils.uneScape(responseResult) : "whetherPrintResult is false"
            );
            if (HttpStatus.SC_OK == statusCode) {
                AuditLogsUtils.getLogger(HttpClientUtils.class).info(msg);
                return responseResult;
            } else {
                AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg);
                return null;
            }
        };
    }


    private static String uneScape(String s) {
        return s.replaceAll("\\n", "\\\\n").replaceAll("\\t", "\\\\t").replaceAll("\\r", "\\\\r");
    }


    /**
     * get 下载文件请求
     *
     * @param url         //
     * @param newFileName //
     */
    public static void getDownloadMaterial(String newFileName, String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap) throws URISyntaxException, IOException {
        paramMap = paramMap == null ? new HashMap<String, String>() : paramMap;
        headerMap = headerMap == null ? new HashMap<String, String>() : headerMap;

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();

            //1、拼装、请求头信息
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }
            // 2、拼装，请求参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 3、初始化
            // 3.1、组装参数，设置传送数据类型为
            URIBuilder uriBuilder = new URIBuilder(url).setCharset(Charset.forName(contentEncoding));
            uriBuilder.setParameters(params);
            HttpRequestBase httpRequestBase = new HttpGet(uriBuilder.build());
            httpRequestBase.setConfig(requestConfig);
            // 3.2、组装请求头
            httpRequestBase.setHeaders(headers.toArray(new Header[headers.size()]));

            for (NameValuePair nameValuePair : uriBuilder.getQueryParams()) {
                paramMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }

            response = httpClient.execute(httpRequestBase);
            String responseResult = (response.getEntity() != null) ? EntityUtils.toString(response.getEntity(), contentEncoding) : "";
            int statusCode = response.getStatusLine().getStatusCode();

            String msg = String.format(serverResultInfoAll, httpRequestBase.getMethod(), httpRequestBase.getURI(), HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), statusCode, HttpClientUtils.uneScape(responseResult));
            if (HttpStatus.SC_OK == statusCode) {
                AuditLogsUtils.getLogger(HttpClientUtils.class).info(msg);
                InputStream is = response.getEntity().getContent();
                FileUtils.copyInputStreamToFile(is, new File(newFileName));
            } else {
                AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg);
            }
        } catch (IOException e) {
            String msg = String.format(serverResultInfoAll, "GET", url, HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), "ERROR", e.getMessage());
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg, e);
            throw e;
        } finally {
            HttpClientUtils.closeResources(httpClient, response);
        }
    }


    /**
     * POST 下载文件请求
     */
    public void postDownloadMaterial(String newFileName, String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerMap) throws IOException {
        if (paramMap == null || paramMap.isEmpty()) {
            throw new RuntimeException("paramMap is null");
        }
        headerMap = headerMap == null ? new HashMap<String, String>() : headerMap;

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();

            //1、拼装、请求头信息
            List<Header> headers = new ArrayList<Header>();
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                headers.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            // 2、拼装，请求参数
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            // 3、初始化
            HttpEntityEnclosingRequestBase httpRequestBase = new HttpPost(url);
            httpRequestBase.setConfig(requestConfig);
            // 3.1、组装参数，设置传送数据类型为
            httpRequestBase.setEntity(new UrlEncodedFormEntity(params, contentEncoding));
            // 3.2、组装请求头
            httpRequestBase.setHeaders(headers.toArray(new Header[headers.size()]));

            response = httpClient.execute(httpRequestBase);
            String responseResult = (response.getEntity() != null) ? EntityUtils.toString(response.getEntity(), contentEncoding) : "";
            int statusCode = response.getStatusLine().getStatusCode();

            String msg = String.format(serverResultInfoAll, httpRequestBase.getMethod(), httpRequestBase.getURI(), HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), statusCode, HttpClientUtils.uneScape(responseResult));
            if (HttpStatus.SC_OK == statusCode) {
                AuditLogsUtils.getLogger(HttpClientUtils.class).info(msg);
                InputStream is = response.getEntity().getContent();
                FileUtils.copyInputStreamToFile(is, new File(newFileName));
            } else {
                AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg);
            }
        } catch (IOException e) {
            String msg = String.format(serverResultInfoAll, "POST", url, HttpClientUtils.uneScape(headerMap.toString()), HttpClientUtils.uneScape(paramMap.toString()), "ERROR", e.getMessage());
            AuditLogsUtils.getLogger(HttpClientUtils.class).error(msg, e);
            throw e;
        } finally {
            HttpClientUtils.closeResources(httpClient, response);
        }
    }

    private static void closeResources(CloseableHttpClient client, CloseableHttpResponse resp) {
        try {
            if (client != null) {
                client.close();
            }
            if (resp != null) {
                resp.close();
            }
        } catch (IOException ignored) {
        }
    }
}