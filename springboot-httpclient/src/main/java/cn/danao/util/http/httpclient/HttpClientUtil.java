package cn.danao.util.http.httpclient;


import cn.danao.exception.ExceptionCode;
import cn.danao.exception.GlobalException;
import cn.danao.util.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

/**
 * @author danao
 * @version 1.0
 * @classname HttpClientUtil
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/24 16:28
 * @since 1.0
 */
@Component
public class HttpClientUtil implements HttpRequest {


    private Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    @Override
    public Map<String, Object> doGet(String url) {
        logger.info(String.format("要请求的url :%s", url));
        Map<String, Object> result = new HashMap<>();
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            result = getResult(response);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> doGet(String url, Map<String, Object> map) {
        Map<String, Object> result = new HashMap<>();
        System.out.println(url);
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        StringBuffer params = new StringBuffer();
        if (map.isEmpty()) {
            params = params.append("");
        } else {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                params.append(key);
                Object val = entry.getValue();
                params.append("=" + val + "&");
            }
        }
        String param = params.substring(0, params.length() - 1);
        logger.warn(String.format("params : %s", param));
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url + "?" + param);
        logger.info(String.format("要请求的url: %s ;请求的参数是:%s", url, param));
        // 响应模型
        CloseableHttpResponse response = null;
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        // 将上面的配置信息 运用到这个Get请求里
        httpGet.setConfig(requestConfig);

        // 由客户端执行(发送)Get请求
        try {
            response = httpClient.execute(httpGet);
            result = getResult(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Map<String, Object> doPost(String url) {
        try {
            Map<String, Object> result = new HashMap<>();
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            result = getResult(response);
            return result;
        } catch (Exception e) {
            throw new GlobalException(ExceptionCode.EXCEPTION_INFO.fillArgs("doPost失败，异常信息" + e.getMessage()));
        }
    }

    @Override
    public Map<String, Object> doPost(String url, Map<String, Object> map) {
        try {
            Map<String, Object> result = new HashMap<>();
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (map != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, String.valueOf(map.get(key))));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            //发送请求
            CloseableHttpResponse response = httpClient.execute(httpPost);
            result = getResult(response);
            return result;
        } catch (Exception e) {
            throw new GlobalException(ExceptionCode.EXCEPTION_INFO.fillArgs("doPost失败，异常信息" + e.getMessage()));
        }
    }

    @Override
    public Map<String, Object> doPostJson(String url, Map<String, Object> map) {
        try {
            Map<String, Object> result = new HashMap<>();
            // 创建Httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            String json = JSON.toJSONString(map);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            result = getResult(response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(ExceptionCode.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
    }

    public Map<String, Object> getResult(CloseableHttpResponse response) {
        try {
            Map<String, Object> result = new HashMap<>();
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                //todo EntityUtils.toString(HttpEntity)方法中操作的是流数据，流数据是一次性数据所以同一个HttpEntity不能使用多次该方法
                String resultStr = EntityUtils.toString(responseEntity);
                int code = response.getStatusLine().getStatusCode();
                logger.info("响应内容长度为:" + responseEntity.getContentLength());
                logger.info("响应内容为:" + resultStr);
                result.put("code", code);
                result.put("result", resultStr);
            }
            return result;
        } catch (Exception e) {
            throw new GlobalException(ExceptionCode.EXCEPTION_INFO.fillArgs("请求参数解析错误"+e.getMessage()));
        }
    }
}
