package cn.danao.test;

import cn.danao.SpringBasicTest;
import cn.danao.bean.RequestInfoModel;
import cn.danao.util.RequestUtil;
import cn.danao.util.RequestUtilImpl;
import cn.danao.util.http.RequestMethod;
import cn.danao.util.http.httpclient.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

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
public class HttpClientTest extends SpringBasicTest {

    @Autowired
    HttpClientUtil httpClient;

    @Autowired
    RequestUtil requsetUtil;

    String url = "http://127.0.0.1:8885";
    //String url = "http://39.104.82.22:8888";

    String line = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";

    @Test
    public void testDoGet(){
        Map<String,Object>  resultOne = httpClient.doGet(url+"/danao/start/success");
        log.info("{}",resultOne);
        Map<String,Object> params = new HashMap<>();
        params.put("argOne","argOne");
        params.put("argTwo","12");
        Map<String,Object>  resultTwo = httpClient.doGet(url+"/danao/start/params",params);
        log.info("{}",resultTwo);
    }

    @Test
    public void testDoPost(){
        Map<String,Object> resultOne = httpClient.doPost(url+"/danao/start/success");
        log.info("{}",resultOne);
        Map<String,Object> params = new HashMap<>();
        params.put("argOne","argOne");
        params.put("argTwo","12");
        Map<String,Object>  resultTwo = httpClient.doPostJson(url + "/danao/start/params/post/json", params);
        log.info("{}",resultTwo);

    }

    @Test
    public void testModelSend(){
        System.out.println(line);
        RequestInfoModel requestInfoModel = new RequestInfoModel();
        url = url+"/danao/start/success";
        requestInfoModel.setUrl(url);
        requestInfoModel.setMethod(RequestMethod.GET);
        requsetUtil.sendHttpRequest(requestInfoModel);
        log.info("[{}]", JSON.toJSONString(requestInfoModel));
    }

}
