package com.danao.controller;

import com.danao.bean.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/1/2 16:02 <br/>
 * descriptionclass <br/>
 * 所有请求优先匹配存在的路由，不存在的路由都会在这里处理
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
public class AppController {

    /**
     * 可以接收所有不存在的get请求
     * 注解 优先于RequestMapping
     *
     * @return json
     */
    @GetMapping
    public ResultCode testGet() {
        return ResultCode.getResult("@GetMapping注解返回，所有不存在路径的GET都会返回");
    }

    /**
     * 可以接收所有不存在的post请求
     * 注解 优先于RequestMapping
     *
     * @return json
     */
    @PostMapping
    public ResultCode testPost() {
        return ResultCode.getResult("@PostMapping注解返回，所有不存在路径的Post都会返回");
    }

    @RequestMapping
    public ResultCode testRequest() {
        return ResultCode.getResult("@RequestMapping注解返回，所有不存在路径都会返回");
    }
}
