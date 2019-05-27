package cn.danao.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Api("登陆测试接口")
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ApiOperation("测试接口")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String  test(){
        logger.info("请求路由为:test"  );
        return "test";
    }



}
