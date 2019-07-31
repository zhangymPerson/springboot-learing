package cn.danao.test;

import cn.danao.SpringBasicTest;
import cn.danao.httpclient.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author danao
 * @version 1.0
 * @classname TestRequest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 10:24
 * @since 1.0
 */
@Slf4j
public class TestRequest extends SpringBasicTest {

    @Autowired
    HttpClientUtil httpClient;

    String url = "http://39.104.82.22:8888/";

    @Test
    public void test(){
        System.out.println("test");
        String result = httpClient.doGet(url+"danao/start/success");
        log.info(result);
    }

}
