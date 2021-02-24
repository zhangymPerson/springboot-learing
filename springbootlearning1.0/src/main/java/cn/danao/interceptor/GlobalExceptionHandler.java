package cn.danao.interceptor;

import cn.danao.bean.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * date 2021/2/24 13:59 <br/>
 * description class <br/>
 * 异常拦截器,处理参数处理异常,返回统一错误码
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultCode handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数异常,异常信息:{}", e.getMessage());
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResultCode.error(defaultMessage);
    }
}
