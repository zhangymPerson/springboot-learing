package cn.danao.resttemplate;

import cn.danao.conf.UrlInfo;
import cn.danao.http.HttpRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname RestTemplateUtil
 * @descriptionclass
 * 1.类的作用 使用RestTemplate 进行远程互联网访问
 * 2.其他说明
 * @createdate 2019/5/24 16:29
 * @since 1.0
 */
@Component
public class RestTemplateUtil implements HttpRequest {

    private static RestTemplate restTemplate = new RestTemplate();

    private static String URL = "http://host:port";


    @Override
    public String doGet(String url ){
        return restTemplate.getForObject(url,String.class);
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

    public static void main(String[] args) {
    }
}
