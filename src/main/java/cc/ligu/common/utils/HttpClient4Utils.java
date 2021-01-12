/*
 * @(#) HttpClientUtils.java 2016年2月3日
 *
 * Copyright 2010 NetEase.com, Inc. All rights reserved.
 */
package cc.ligu.common.utils;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import cc.ligu.common.entity.ResultEntity;

/**
 * HttpClient工具类
 *
 * @author zhangwd
 * @version 2016年2月3日
 */
public class HttpClient4Utils {
    /**
     * DEFAULT_HTTP_CLIENT 3秒，连接数最大值需要调整100
     */
    public static final HttpClient DEFAULT_HTTP_CLIENT =
        HttpClient4Utils.createHttpClient(100, 20, 3 * 1000, 3 * 1000, 3 * 1000);
    public static final String CHARSET_UTF_8 = "utf-8";
    private static final Logger LOG = LoggerFactory.getLogger("HttpClient4Utils");
    private static final String APPLICATION_JSON = "application/json";
    /**
     * 最大连接数
     */
    private static final int MAX_CONNECTION_NUM = 1000;
    /**
     * 连接池连接数 属性
     */
    private static final int MAX_PER_ROUTE = 80;
    static AtomicInteger errorCount = new AtomicInteger(0);
    /**
     * 连接池manager
     */
    private static PoolingHttpClientConnectionManager cm = null;
    /**
     * 设置两分钟：nsfw检测时间非常慢 + nsfw线程池等待时间  只对于此项目适用 对于其他项目不适用 这种设置 连接池请求配置
     */
    private static RequestConfig requestConfig =
        RequestConfig.custom().setSocketTimeout(2 * 60 * 1000).setConnectTimeout(2 * 60 * 1000)
            .setConnectionRequestTimeout(3 * 1000).build();

    /**
     * 构造函数
     */
    private HttpClient4Utils() {

    }

    /**
     * <p>
     * <code>getPoolManager</code>获取http线程池
     * </p>
     */
    private static synchronized PoolingHttpClientConnectionManager getPoolManager() {
        final String methodName = "getPoolManager";
        if (null == cm) {
            SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
            try {
                sslContextBuilder.loadTrustMaterial(new TrustSelfSignedStrategy());
                SSLConnectionSocketFactory socketFactory =
                    new SSLConnectionSocketFactory(sslContextBuilder.build());
                Registry<ConnectionSocketFactory> socketFactoryRegistry =
                    RegistryBuilder.<ConnectionSocketFactory>create().register("https", socketFactory)
                        .register("http", new PlainConnectionSocketFactory()).build();
                cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
                // 设置连接池大小
                cm.setMaxTotal(MAX_CONNECTION_NUM);
                cm.setDefaultMaxPerRoute(MAX_PER_ROUTE);
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }
        return cm;
    }

    /**
     * 实例化HttpClient
     *
     * @param maxTotal
     * @param maxPerRoute
     * @param socketTimeout
     * @param connectTimeout
     * @param connectionRequestTimeout
     * @return
     */
    public static HttpClient createHttpClient(int maxTotal, int maxPerRoute, int socketTimeout,
        int connectTimeout, int connectionRequestTimeout) {
        RequestConfig defaultRequestConfig =
            RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(maxTotal);
        cm.setDefaultMaxPerRoute(maxPerRoute);
        return HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
            .build();
    }
    // post请求=========================================================

    /**
     * 有线程池的httpclient
     *
     * @param config
     * @return
     */
    public static CloseableHttpClient getHttpsClient(RequestConfig config) {
        final String methodName = "getHttpsClient";
        CloseableHttpClient httpClient =
            HttpClients.custom().setDefaultRequestConfig(config).setConnectionManager(getPoolManager())
                .build();
        return httpClient;
    }

    public static String sendPostJson(HttpClient httpClient, String url, JSONObject jsonData,
        String encodeCharset) {
        String resp = "";
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            ByteArrayOutputStream originalContent = new ByteArrayOutputStream();
            originalContent.write(jsonData.toJSONString().getBytes(StandardCharsets.UTF_8));
            ByteArrayEntity byteentity = new ByteArrayEntity(originalContent.toByteArray());
            byteentity.setContentType(APPLICATION_JSON);
            if (encodeCharset == null || encodeCharset.length() < 1) {
                encodeCharset = "utf-8";
            }
            httpPost.setHeader("Content-Type", "" + APPLICATION_JSON + "; charset=" + encodeCharset);
            httpPost.setEntity(byteentity);
            response = getHttpsClient(RequestConfig.DEFAULT).execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (null != entity) {
                Charset cs = ContentType.getOrDefault(entity).getCharset();
                if (cs == null) {
                    cs = StandardCharsets.UTF_8;
                }
                resp = EntityUtils.toString(entity, cs);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            System.out.println(System.currentTimeMillis());
            System.out.println(errorCount.incrementAndGet());
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return resp;
    }

    public static String sendPostString(HttpClient httpClient, String url, String reqData,
        String encodeCharset, String contentType) {
        String resp = "";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(reqData == null ? "" : reqData, encodeCharset));
        CloseableHttpResponse response = null;
        try {

            if (encodeCharset == null || encodeCharset.length() < 1) {
                encodeCharset = "utf-8";
            }
            if (contentType == null || contentType.length() < 1) {
                contentType = "application/x-www-form-urlencoded";
            }
            httpPost.setHeader("Content-Type", "" + contentType + "; charset=" + encodeCharset);
            httpPost.setEntity(new StringEntity(reqData == null ? "" : reqData, encodeCharset));
            response = (CloseableHttpResponse)httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (null != entity) {
                Charset cs = ContentType.getOrDefault(entity).getCharset();
                if (cs == null) {
                    cs = StandardCharsets.UTF_8;
                }
                resp = EntityUtils.toString(entity, cs);
                EntityUtils.consume(entity);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return resp;
    }
    // 加线程池的 httpclient get请求============================================

    /**
     * 发送Get请求
     *
     * @param url
     * @return
     */
    public static String sendHttpGet(String url, Map<String, String> httpHeaders) {
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        HttpGet httpGet = null;
        try {
            CloseableHttpClient httpClient = getHttpsClient(requestConfig);
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            if (httpHeaders != null && httpHeaders.size() > 0) {
                for (Map.Entry entry : httpHeaders.entrySet()) {
                    httpGet.setHeader((String)entry.getKey(), (String)entry.getValue());
                }
            }
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
            response.close();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                if (httpGet != null) {
                    httpGet.releaseConnection();
                }
            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return responseContent;
    }

    public static ResultEntity test(String appId){

        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 600; j++) {
                    System.out.println(atomicInteger.incrementAndGet());
                    //1w 异常12次
                    //String serverUrl ="http://36.7.109.47:7080/im-callback/V1.0/imcallback?CallbackCommand=C2C.CallbackBeforeSendMsg&ClientIP=27.17.60.148&OptPlatform=Web&SdkAppid=1400461348&appId=zjy_test2&contenttype=json";
                    //5w 0异常 //String serverUrl ="http://172.31.185.193:9994/im-callback/V1.0/imcallback?CallbackCommand=C2C.CallbackBeforeSendMsg&ClientIP=27.17.60.148&OptPlatform=Web&SdkAppid=1400461348&appId=zjy_test&contenttype=json";
                    //6w 0 String serverUrl ="http://47.98.50.38:9994/im-callback/V1.0/imcallback?CallbackCommand=C2C.CallbackBeforeSendMsg&ClientIP=27.17.60.148&OptPlatform=Web&SdkAppid=1400461348&appId=zjy_test&contenttype=json";
                    String serverUrl ="http://perf-aim.changyan.com/im-callback/V1.0/imcallback?CallbackCommand=C2C.CallbackBeforeSendMsg&ClientIP=27.17.60.148&OptPlatform=Web&SdkAppid=1400461348&appId="+appId+"&contenttype=json";
                    String body =
                        "{\"version\":\"v1\",\"CallbackCommand\":\"C2C.CallbackBeforeSendMsg\",\"ClientIP\":\"27.17.60.148\",\"OptPlatform\":\"Web\",\"SdkAppid\":\"1400461348\",\"appId\":\"zjy_test7\",\"contenttype\":\"json\",\"MsgBody\":[{\"MsgContent\":{\"Ext\":\"\",\"Desc\":\"您收到了一条新消息\",\"Data\":\"{\\\"appId\\\":\\\"zjy_test\\\",\\\"ext\\\":{\\\"rmqAddr\\\":\\\"172.16.122.24:9876\\\"},\\\"mId\\\":\\\"testbatchCallback_test5\\\",\\\"mb\\\":\\\"{\\\\\\\"actns\\\\\\\":[\\\\\\\"zhuosheng23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 23939 \\\\\\\"],\\\\\\\"blseq\\\\\\\":0,\\\\\\\"fil\\\\\\\":false,\\\\\\\"gId\\\\\\\":\\\\\\\"\\\\\\\",\\\\\\\"rId\\\\\\\":\\\\\\\"50034822\\\\\\\",\\\\\\\"retri\\\\\\\":true,\\\\\\\"ruIds\\\\\\\":[],\\\\\\\"ruts\\\\\\\":[],\\\\\\\"seq\\\\\\\":315005,\\\\\\\"stype\\\\\\\":3004,\\\\\\\"suId\\\\\\\":\\\\\\\"2001\\\\\\\",\\\\\\\"t\\\\\\\":1610357043494,\\\\\\\"v\\\\\\\":\\\\\\\"1.0\\\\\\\"}\\\",\\\"mt\\\":211,\\\"st\\\":1610357103954,\\\"v\\\":2}\",\"Sound\":\"\"},\"MsgType\":\"TIMCustomElem\"}]}";
                    JSONObject jsonObject = JSONObject.parseObject(body);
                    String responseContent = HttpClient4Utils
                        .sendPostJson(DEFAULT_HTTP_CLIENT, serverUrl, jsonObject, CHARSET_UTF_8);
                    //System.out.println(responseContent);
                    if (!"{\"ErrorInfo\":\"\",\"ErrorCode\":0,\"ActionStatus\":\"OK\"}"
                        .equals(responseContent)) {
                        System.out.println(responseContent);
                    }
                }
            }).start();
        }
        return null;
    }

}
