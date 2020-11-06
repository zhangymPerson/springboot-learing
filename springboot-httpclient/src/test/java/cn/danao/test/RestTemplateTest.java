package cn.danao.test;

import cn.danao.SpringBasicTest;
import cn.danao.util.http.resttemplate.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author danao
 * @version 1.0
 * @classname RestTemplateTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 11:31
 * @since 1.0
 */
@Slf4j
public class RestTemplateTest extends SpringBasicTest {

    @Autowired
    public RestTemplateUtil restTemplateUtil;

    @Autowired
    public RestTemplate restTemplate;

    String url = "http://127.0.0.1:8885";
    //String url = "http://39.104.82.22:8888";

    String line = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";

    @Test
    public void testDoGet() {
        System.out.println(line);
        String resultOne = restTemplateUtil.doGet(url + "/danao/start/success");
        log.info(resultOne);
        Map<String, Object> params = new HashMap<>();
        params.put("argOne", "argOne");
        params.put("argTwo", "12");
        String resultTwo = restTemplateUtil.doGet(url + "/danao/start/params", params);
        log.info(resultTwo);
    }

    @Test
    public void testDoGetAndToken() {
        String key = "key";
        String type = "type";
        String token = "token";
        String url = "http://127.0.0.1:8885/danao/hello/token?word={testWord}&type={testType}";
        Map<String, String> params = new HashMap<>();
        params.put("testWord", key);
        params.put("testType", type);
        HttpHeaders headers = new HttpHeaders();
        headers.put("token", Collections.singletonList(token));
        //带token的get请求发送方式,参数传递方式, url中使用 {key} 然后在最后的map中 进行赋值
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class, params);
        String string = Optional.ofNullable(response.getBody()).get();
        log.info(string);
    }


    @Test
    public void testDoPost() {
        System.out.println(line);
    }

}
