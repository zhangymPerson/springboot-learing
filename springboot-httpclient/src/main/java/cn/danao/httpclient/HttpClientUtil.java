package cn.danao.httpclient;



import cn.danao.http.HttpRequest;
import cn.danao.util.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname HttpClientUtil
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/24 16:28
 * @since 1.0
 */
@Component(value = "httpClient")
public class HttpClientUtil implements HttpRequest {


    private Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    @Override
    public String doGet(String url) {
        logger.info(String.format("要请求的url :%s" ,url));
        String result = "";
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                //todo EntityUtils.toString(HttpEntity)方法中操作的是流数据，流数据是一次性数据所以同一个HttpEntity不能使用多次该方法
                result =  EntityUtils.toString(responseEntity);
                logger.info("响应内容长度为:" + responseEntity.getContentLength());
                logger.info("响应内容为:" + result);
            }
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
    public String doGet(String url, Map<String, String> map) {
        String result = "";
        System.out.println(url);
        System.out.println(MapUtils.hashmapToString(map));
        logger.info(String.format("要请求的url %s ",url,MapUtils.hashmapToString(map)));
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        StringBuffer params = new StringBuffer();
        if(map.isEmpty()){
            params =  params .append("");
        }else {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                params.append( key);
                Object val = entry.getValue();
                params.append("=" + val + "&");
            }
        }
        String param = params.substring(0,params.length()-1);
        logger.warn(String.format("params : %s",param));
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url + "?" + param);
        logger.info(String.format("要请求的url: %s ;请求的参数是:%s",url ,param));
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
             // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                result = EntityUtils.toString(responseEntity);
                logger.info(String.format("响应内容为:%s",result ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String doPost(String url) {
        return null;
    }

    @Override
    public String doPost(String url, Map<String, String> map) {
        return null;
    }
}
