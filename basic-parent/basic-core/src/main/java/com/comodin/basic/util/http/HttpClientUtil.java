package com.comodin.basic.util.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * //log.info(" ==> Server Request: GET	---URL:    " + url);
 * //log.info(" ==> Server Params : ");
 * //log.info(" <== Server Result: " + responseResult);
 * <p>
 * //log.info(" ==> Server Request: POST	---URL:    " + url);
 * //log.info(" ==> Server Params: " + JSON.toJSONString(paramMap));
 * //log.info(" <== Server Result: " + responseResult);
 */
@SuppressWarnings("Duplicates")
public class HttpClientUtil {
    private static Log log = LogFactory.getLog(HttpClientUtil.class);

    // set Timeout
    private static final RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(500000).setConnectTimeout(50000).setSocketTimeout(50000).build();

    private static final String serverRequestInfo = "" +
            "\n===>>>Server Request Address: %s\t%s" +
            "\n===>>>Server Request Headers: %s" +
            "\n===>>>Server Request Params : %s";
    private static final String serverResultInfo = "" +
            "\n===>>>Server Request Address: %s\t%s" +
            "\n<<<===Server Return Status: %s" +
            "\n<<<===Server Return Result: %s";

    public static String getRequest(String url) throws IOException, HttpClientException {
        return getRequest(url, Consts.UTF_8.toString());
    }

    public static String getRequest(String url, String contentEncoding) throws IOException, HttpClientException {
        return getRequest(url, contentEncoding, new HashMap<>());
    }

    public static String getRequest(String url, String contentEncoding, Map<String, String> paramMap) throws IOException, HttpClientException {
        return getRequest(url, contentEncoding, paramMap, new HashMap<>());
    }

    public static String getRequest(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerParamMap) throws HttpClientException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            URIBuilder uriBuilder = new URIBuilder(url).setCharset(Charset.forName(contentEncoding));
            if (paramMap != null && !paramMap.isEmpty()) paramMap.forEach(uriBuilder::setParameter);//设置单独参数

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            httpGet.setConfig(requestConfig);

            if (headerParamMap != null && !headerParamMap.isEmpty()) headerParamMap.forEach(httpGet::setHeader);//增加请求头
            log.info(String.format(serverRequestInfo, httpGet.getMethod(), httpGet.getURI(), Arrays.toString(httpGet.getAllHeaders()), new URIBuilder(httpGet.getURI()).getQueryParams()));

            return httpClient.execute(httpGet, processHttpResponseResult(url, httpGet.getMethod(), contentEncoding));
        } catch (URISyntaxException e) {
            String errorInfo = "Syntax URL Fail. " + url;
            log.error(errorInfo);
            throw new HttpClientException(errorInfo, e);
        } catch (IOException ex) {
            log.error(ex);
            throw new HttpClientException(ex);
        }
    }

    /**
     * post方式提交 from表单
     */
    public static String postForm(String url, Map<String, String> paramMap) throws IOException, HttpClientException {
        return postForm(url, Consts.UTF_8.toString(), paramMap);
    }

    public static String postForm(String url, String contentEncoding, Map<String, String> paramMap) throws IOException, HttpClientException {
        return postForm(url, contentEncoding, paramMap, new HashMap<>());
    }

    public static String postForm(String url, Map<String, String> paramMap, Map<String, String> headerParamMap) throws IOException, HttpClientException {
        return postForm(url, Consts.UTF_8.toString(), paramMap, headerParamMap);
    }

    /**
     * post方式提交 from表单
     */
    public static String postForm(String url, String contentEncoding, Map<String, String> paramMap, Map<String, String> headerParamMap) throws IOException, HttpClientException {
        if (paramMap == null || paramMap.isEmpty()) {
            throw new RuntimeException("paramMap is null");
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        if (headerParamMap != null && !headerParamMap.isEmpty()) headerParamMap.forEach(httpPost::setHeader);//增加请求头

        // 创建参数队列
        List<BasicNameValuePair> basicNameValuePairList = new ArrayList<>();
        paramMap.forEach((paramName, paramValue) -> basicNameValuePairList.add(new BasicNameValuePair(paramName, paramValue)));
        //设置传送数据类型为
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(basicNameValuePairList, contentEncoding);
        urlEncodedFormEntity.setContentEncoding(contentEncoding);
        httpPost.setEntity(urlEncodedFormEntity);

        log.info(String.format(serverRequestInfo, httpPost.getMethod(), httpPost.getURI(), Arrays.toString(httpPost.getAllHeaders()), basicNameValuePairList.toString()));
        return processHttpResponseResult(httpClient, httpClient.execute(httpPost), contentEncoding);
    }


    public static String postFormMultipart(String url, Map<String, ?> paramMap) throws IOException, HttpClientException {
        return postFormMultipart(url, Consts.UTF_8.toString(), paramMap);
    }

    public static String postFormMultipart(String url, String contentEncoding, Map<String, ?> paramMap) throws IOException, HttpClientException {
        return postFormMultipart(url, contentEncoding, paramMap, new HashMap<>());
    }


    public static String postFormMultipart(String url, String contentEncoding, Map<String, ?> paramMap, Map<String, String> headerParamMap) throws IOException, HttpClientException {
        if (paramMap == null || paramMap.isEmpty()) {
            throw new RuntimeException("paramMap is null");
        }

        CloseableHttpClient httpClient = HttpClients.createMinimal();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        if (null != headerParamMap && !headerParamMap.isEmpty()) {
            headerParamMap.forEach(httpPost::setHeader);//增加请求头
        }

        Map<String, String> logStrParamMap = new HashMap<>();
        String logFileParamPrefix = "\n===>>>Server Request Params : %s";
        //Map<String, String> logStrParamMap = new HashMap<>();
        String logInputStreamParamPrefix = "\n===>>>Server Request Params : %s";
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        paramMap.forEach((paramName, paramValue) -> {
            if (paramValue instanceof String) {
                String value = String.valueOf(paramValue);
                //multipartEntityBuilder.addTextBody(paramName, value, ContentType.TEXT_PLAIN);
                multipartEntityBuilder.addTextBody(paramName, value, ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), contentEncoding));
                logStrParamMap.put(paramName, String.valueOf(paramValue));
            } else if (paramValue instanceof File) {
                File file = (File) paramValue;
                multipartEntityBuilder.addBinaryBody(paramName, file, ContentType.MULTIPART_FORM_DATA, file.getName());
            } else if (paramValue instanceof InputStream) {
                InputStream inputStream = (InputStream) paramValue;
                multipartEntityBuilder.addBinaryBody(paramName, inputStream, ContentType.MULTIPART_FORM_DATA, "");
            } else {
                throw new RuntimeException("post form data value type: [String,File,InputStream] current paramName:" + paramName + " of paramValue type: " + paramValue.getClass().getTypeName());
            }
        });
        httpPost.setEntity(multipartEntityBuilder.build());

        log.info(String.format(serverRequestInfo, httpPost.getMethod(), httpPost.getURI(), Arrays.toString(httpPost.getAllHeaders()), multipartEntityBuilder.toString()));
        return processHttpResponseResult(httpClient, httpClient.execute(httpPost), contentEncoding);
    }


    ///**
    // * get 下载文件请求
    // *
    // * @param url         //
    // * @param newFileName //
    // */
    //public static void getRequestDownloadMaterial(String url, String newFileName) {
    //
    //    CloseableHttpClient client = null;
    //    CloseableHttpResponse resp = null;
    //
    //    try {
    //        client = HttpClients.createDefault();
    //        HttpGet get = new HttpGet(url);
    //
    //        resp = client.execute(get);
    //        int statusCode = resp.getStatusLine().getStatusCode();
    //        if (statusCode >= 200 && statusCode < 300) {
    //            InputStream is = resp.getEntity().getContent();
    //            FileUtils.copyInputStreamToFile(is, new File(newFileName));
    //        }
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    } finally {
    //        closeResources(client, resp);
    //    }
    //}

    private static ResponseHandler<String> processHttpResponseResult(String url, String requestMethod, String contentEncoding) throws HttpClientException {
        return response -> {
            String responseEntityString;
            int statusCode = response.getStatusLine().getStatusCode();
            responseEntityString = (response.getEntity() != null) ? EntityUtils.toString(response.getEntity(), contentEncoding) : null;
            if (HttpStatus.SC_OK == statusCode) {
                return responseEntityString;
            } else {
                String errorInfo = String.format(serverResultInfo, url, requestMethod, statusCode, responseEntityString);
                log.error(errorInfo);
                throw new HttpClientException(errorInfo);
            }
        };
    }

    private static String processHttpResponseResult(CloseableHttpClient httpClient, final CloseableHttpResponse httpResponse, String contentEncoding) throws IOException, HttpClientException {
        String serverResultInfo = "" +
                "\n<<<===Server Return Status: %s" +
                "\n<<<===Server Return Result: %s";
        Integer statusCode = null;
        String responseResult;
        try {
            statusCode = httpResponse.getStatusLine().getStatusCode();
            responseResult = EntityUtils.toString(httpResponse.getEntity(), contentEncoding);//Entity存的就是，我们所返回的所有东西

            if (HttpStatus.SC_OK == statusCode) {
                log.info(String.format(serverResultInfo, statusCode, responseResult));
                return responseResult;
            } else {
                log.error(String.format(serverResultInfo, statusCode, responseResult));
                throw new HttpClientException(String.format(serverResultInfo, statusCode, responseResult));
            }
        } catch (IOException e) {
            log.error(String.format(serverResultInfo, statusCode, e.getMessage()), e);
            throw e;
        } finally {
            closeResources(httpClient, httpResponse);
        }
    }

    private static void closeResources(CloseableHttpClient httpClient, CloseableHttpResponse httpResponse) {
        try {
            if (httpClient != null) httpClient.close();
            if (httpResponse != null) httpResponse.close();
        } catch (IOException ignored) {
        }
    }


    //
    //public static String postRequest(String url, String data) throws IOException {
    //    return postRequest(url, Consts.UTF_8.toString(), data);
    //}
    //
    //public static String postRequest(String url, String contentEncoding, String data) throws IOException {
    //    return postRequest(url, contentEncoding, data, null);
    //}
    //
    //public static String postRequest(String url, String contentEncoding, String data, Map<String, String> headerParamMap) throws IOException {
    //    log.info("      ==> Server Request: POST	---URL:    " + url);
    //    log.info("      ==> Server Params: " + data);
    //
    //    CloseableHttpClient httpClient = null;
    //    CloseableHttpResponse httpResponse = null;
    //    try {
    //        httpClient = HttpClients.createDefault();
    //        HttpPost httpPost = new HttpPost(url);
    //        //增加请求头
    //        if (null != headerParamMap && !headerParamMap.isEmpty()) headerParamMap.forEach(httpPost::setHeader);
    //
    //        //设置传送数据类型为
    //        StringEntity entity = new StringEntity(data, ContentType.parse(contentEncoding)); //设置字符编码
    //        httpPost.setEntity(entity);
    //        httpResponse = httpClient.execute(httpPost);
    //        return processHttpResponseResult(httpClient, httpResponse, contentEncoding);
    //    } catch (Exception e) {
    //        log.error(e.getMessage(), e);
    //        throw e;
    //    } finally {
    //        closeResources(httpClient, httpResponse);
    //    }
    //}

}