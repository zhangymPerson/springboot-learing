package com.danao.controller;

import com.danao.exception.SelfException;
import com.danao.server.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    HelloServer helloServer;

    /**
     * 运行时异常的捕获测试接口
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("请求路由为 test 1 ");
        double i =0 ;
        i =1/0;
        return "succsee;";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("请求路由为 test 2 ");
        throw new RuntimeException("advice1 - exception2");
     }

     @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public String testSelfException(){
         System.out.println("请求路由为 test 3");
        throw new SelfException("自定义的异常处理信息抛出");
    }

    @RequestMapping(value = "test4" ,method = RequestMethod.GET)
    public String testServerException(){
        System.out.println("请求路由为test4");
        int i = helloServer.getInt();
        return "success";
    }

}
