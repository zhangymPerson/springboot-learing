package com.danao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname GlobalException
 * @descriptionclass 1.全局异常处理类
 * ControllerAdvice 这个注解就是获取全局异常处理的
 * 这个注解只能处理controller里面的异常
 * 为了避免返回错误页面。可以将异常捕获，返回异常的json串
 * 2.todo 这个类是要解决spring 框架中的全局异常管理的
 * @createdate 2019/5/9 9:17
 * @since 1.0
 */
@ControllerAdvice
public class GlobalException {


    /**
     * 全局顶层异常信息的捕获处理  Exception类的处理
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionCode defaultException() {
        return ExceptionCode.DEFAULT;
    }


    /**
     * 这里的注解可以指定需要捕获的异常类型
     *
     * @param selfException 可以添加参数
     * @return
     */
    @ExceptionHandler(SelfException.class)
    @ResponseBody
    public ExceptionCode selfException(SelfException selfException) {
        return selfException.getCm();
    }

}
