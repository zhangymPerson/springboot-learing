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
 * <p>
 * 自定义错误页面路径，且需要实现错误页面路径的请求否则直接请求不通  This 127.0.0.1 page can’t be found 404
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@Slf4j
public class SelfErrorController implements ErrorController {

    private static final String ERROR_PATH = "/selferror";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * 自定义错误页面的处理方式
     * <p>
     * ERROR_PATH 自定义无效 实现 ErrorController 则必须实现 /error的处理 否则 无法实现错误处理
     *
     * @return 错误页面内容
     */
    @RequestMapping(value = "/error")
    public ResultCode error() {
        return ResultCode.setResultObject("默认 error 路径的自定义错误返回页内容");
    }

    /**
     * 自定义错误页面的路由
     *
     * @return 错误页面内容
     */
    @RequestMapping(value = "/selferror")
    public ResultCode errors() {
        return ResultCode.setResultObject("自定义 errors 错误返回页内容");
    }


}
