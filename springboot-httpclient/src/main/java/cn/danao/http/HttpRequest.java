package cn.danao.http;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname HttpRequest
 * @descriptionclass
 * 1.定义接口 规范工具类的实现
 * 2.get和post请求两种方式
 * @createdate 2019/5/24 17:18
 * @since 1.0
 */
public interface HttpRequest {

    /**
     * 发送处理get请求的方法
     * @param url
     * @return
     */
    String doGet(String url);

    /**
     * 发送处理get请求的方法 可以携带指定请求头
     * @param url
     * @param map
     * @return
     */
    String doGet(String url,Map<String,String> map);

    /**
     * 发送处理post的请求
     * @param url
     * @return
     */
    String doPost(String url);

    /**
     * 发送携带指定请求头的post请求
     * @param url
     * @param map
     * @return
     */
    String doPost(String url,Map<String,String> map);

}
