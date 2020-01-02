package com.danao.controller;

import com.danao.bean.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/1/2 16:02 <br/>
 * descriptionclass <br/>
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
        return ResultCode.SUCCESS;
    }

    /**
     * 可以接收所有不存在的post请求
     * 注解 优先于RequestMapping
     *
     * @return json
     */
    @PostMapping
    public ResultCode testPost() {
        return ResultCode.SUCCESS;
    }

    @RequestMapping
    public ResultCode testRequest() {
        return ResultCode.FAIL;
    }
}
