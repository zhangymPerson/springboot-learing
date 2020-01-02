package com.danao.controller;


import com.danao.bean.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/1/2 15:28 <br/>
 * descriptionclass <br/>
 * <p>
 * 错误页面处理
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@Slf4j
public class SelfErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * 自定义错误页面的处理方式
     *
     * @return 错误页面内容
     */
    @RequestMapping(value = "/error")
    public ResultCode error() {
        return ResultCode.getResult("自定义错误返回页内容");
    }
}
