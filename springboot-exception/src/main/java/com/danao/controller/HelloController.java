package com.danao.controller;

import com.danao.bean.ResultCode;
import com.danao.exception.ExceptionCode;
import com.danao.exception.SelfException;
import com.danao.server.HelloServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    HelloServer helloServer;

    /**
     * 运行时异常的捕获测试接口
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        System.out.println("请求路由为 test 1 ");
        try {
            double i = 0;
            i = 1 / 0;
            return "succsee;";
        } catch (Exception e) {
            throw new SelfException(ExceptionCode.SELF_INFO.fillClassNameArgs(this.getClass(), e.getMessage()));
        }
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("请求路由为 test 2 ");
        throw new RuntimeException("advice1 - exception2");
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String testSelfException() {
        System.out.println("请求路由为 test 3");
        throw new SelfException("自定义的异常处理信息抛出");
    }

    @RequestMapping(value = "test4", method = RequestMethod.GET)
    public String testServerException() {
        System.out.println("请求路由为test4");
        int i = helloServer.getInt();
        return "success";
    }


    @RequestMapping("/resutTest")
    public ResultCode tests() {
        System.out.println("请求路由为 test 1 ");
        try {
            double i = 0;
            i = 1 / 0;
            return ResultCode.SUCCESS;
        } catch (Exception e) {
            throw new SelfException(ExceptionCode.SELF_INFO.fillClassNameArgs(this.getClass(), e.getMessage()));
        }
    }


    @RequestMapping("/testMap")
    public ResultCode testMap() {
        System.out.println("请求路由为 test 1 ");
        try {
            //测试map
            Map<String, Object> allergyMap = new HashMap<String, Object>();
            //有无过敏
            allergyMap.put("is_allergy", "有/无");
            //过敏物
            allergyMap.put("allergy_thing", "过敏物");
            //用户id
            allergyMap.put("user_id", "15235142525");
            //成员id
            allergyMap.put("member_id", "45safd54sadf");
            return ResultCode.setResultObject(allergyMap);
        } catch (Exception e) {
            throw new SelfException(ExceptionCode.SELF_INFO.fillClassNameArgs(this.getClass(), e.getMessage()));
        }
    }


}
