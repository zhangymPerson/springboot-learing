package cn.danao.controller;

import cn.danao.bean.UserInfo;
import cn.danao.conf.UrlInfo;
import cn.danao.httpclient.HttpClientUtil;
import cn.danao.resttemplate.RestTemplateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("测试入口")
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    public UrlInfo info;
    @Autowired
    public RestTemplateUtil restTemplateUtil;

    @Autowired
    public HttpClientUtil httpClientUtil;


    @ApiOperation("测试get请求")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Map<String,String>  test(){
        Map<String,String> result = new HashMap<>();
        logger.info("请求路由为:test"  );
        List<String> urls = getUrl(info);
        logger.info("urls = " + toString(urls));
        if(urls.isEmpty()){
            logger.info("无需发起get请求");
        }else {
            Map<String,String> params = new HashMap<>();
            params.put("id","1");
            params.put("name","name");
            for(String url:urls){
                //todo  测试1
                String resultStr = "";
                //resultStr = restTemplateUtil.doGet(url);
                //logger.warn(String.format("测试1的结果:%s  ",resultStr));
                //todo 测试2
                resultStr = httpClientUtil.doGet(url,params);
                logger.warn(String.format("测试2的结果:%s",resultStr));
                result.put(url,resultStr);
            }
        }
        return result;
    }

    @RequestMapping(value="/tests/{id}/{name}",method= RequestMethod.GET)
    public Object sayHello(@PathVariable("id") Integer id,@PathVariable("name") String name){
       logger.info("请求/test/"+id+"/"+name);
        UserInfo userInfos = new UserInfo(id,name,12,"男","备注");
        return userInfos;
    }



    /**
     * 获取get请求的配置
     * @param info
     * @return
     */
    public static List<String> getUrl(UrlInfo info){
        List<String> urls = new ArrayList<>();
        System.out.println(info.toString());
        String url =  String.format("http://%s:%s",info.host,info.port);
        System.out.println(url);
        String[] routes = info.getRoute.split(";");
        for(String s:routes){
            //System.out.println(url + s);
            urls.add(url+s);
        }
        return urls;
    }

    /**
     * 获取post请求的配置
     * @param info
     * @return
     */
    public static List<String> postUrl(UrlInfo info){
        List<String> urls = new ArrayList<>();
        System.out.println(info.toString());
        String url =  String.format("http://%s:%s",info.host,info.port);
        System.out.println(url);
        String[] routes = info.postRoute.split(";");
        for(String s:routes){
            //System.out.println(url + s);
            urls.add(url+s);
        }
        return urls;
    }


    public String toString(List list){
        String  s = "";
        for(Object obj:list){
            s = s + obj.toString() + "      ";
        }
        return s;
    }
}
