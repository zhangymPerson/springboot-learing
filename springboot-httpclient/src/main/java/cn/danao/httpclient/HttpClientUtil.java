package cn.danao.httpclient;

import cn.danao.http.HttpRequest;
import org.springframework.stereotype.Component;

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
@Component
public class HttpClientUtil implements HttpRequest {
    @Override
    public String doGet(String url) {
        return null;
    }

    @Override
    public String doGet(String url, Map<String, String> map) {
        return null;
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
