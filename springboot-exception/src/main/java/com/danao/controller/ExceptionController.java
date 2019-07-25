package com.danao.controller;

import com.danao.bean.ResultCode;
import com.danao.exception.ExceptionCode;
import com.danao.exception.SelfException;
import com.danao.server.ExceptionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname ExceptionController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/25 12:05
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @Autowired
    private ExceptionServer exceptionServer;
    /**
     * 运行时异常的捕获测试接口
     *
     * @return
     */
    @RequestMapping("/test")
    public ResultCode test() {
        System.out.println("请求路由为e ");
        try {
            Map<String,Object> result = exceptionServer.exceptionMethod(null);
            return ResultCode.getResult(result);
        } catch (Exception e) {
            throw new SelfException(ExceptionCode.SELF_INFO.fillClassNameArgs(this.getClass(), e.getMessage()));
        }
    }

}
