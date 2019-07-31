package cn.danao.test;

import cn.danao.SpringBasicTest;
import cn.danao.util.http.resttemplate.RestTemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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

    String url = "http://127.0.0.1:8885";
    //String url = "http://39.104.82.22:8888";

    String line = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";

    @Test
    public void testDoGet() {
        System.out.println(line);
        String resultOne =restTemplateUtil.doGet(url+"/danao/start/success");
        log.info(resultOne);
        Map<String,Object> params = new HashMap<>();
        params.put("argOne","argOne");
        params.put("argTwo","12");
        String resultTwo = restTemplateUtil.doGet(url+"/danao/start/params",params);
        log.info(resultTwo);
    }

    @Test
    public void testDoPost() {
        System.out.println(line);
    }

}
