package cn.danao.controller;

import cn.danao.conf.UrlInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danao
 * @version 1.0
 * @classname HttpClientController
 * @descriptionclass
 * 1.测试httpclient接口
 * 2.其他说明
 * @createdate 2019/5/27 11:12
 * @since 1.0
 */
@Api("测试httpclient")
@RestController
@RequestMapping(value = "/http")
public class HttpClientController {

    Logger logger = LoggerFactory.getLogger(HttpClientController.class);

    @Autowired
    public UrlInfo urlInfo;

    @ApiOperation("测试")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayhello(){
        logger.info("请求路由/http/hello");
        return "hello";
    }

    @ApiOperation("测试get请求")
    public String doGetTest(){
        return "success";
    }



}
