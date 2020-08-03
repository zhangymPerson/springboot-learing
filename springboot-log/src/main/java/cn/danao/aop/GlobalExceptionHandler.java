package cn.danao.aop;


import cn.danao.exception.ApiErrorInfoException;
import cn.danao.exception.ErrorInfoInterface;
import cn.danao.exception.GlobalErrorInfoException;
import cn.danao.exception.ResultBody;
import cn.danao.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 切 ApiErrorInfoException 异常
     *
     * @param exception ApiErrorInfoException
     * @param response  HttpServletResponse
     * @return ResultBody
     */
    @ExceptionHandler(value = ApiErrorInfoException.class)
    @ResponseBody
    public void errorHandlerOverJson(ApiErrorInfoException exception, HttpServletResponse response) {
        ResultBody resultBody = new ResultBody();
        Long errorCode = exception.getErrorCode();
        String message = exception.getMessage();
        Object data = exception.getData();
        resultBody.setCode(errorCode);
        resultBody.setMessage(message);
        resultBody.setResult(data);
        ResponseUtils.write(response, resultBody);
    }

    /**
     * 切 GlobalErrorInfoException 异常
     *
     * @param exception ApiErrorInfoException
     * @param request   HttpServletRequest
     * @return ResultBody
     */
    @ExceptionHandler(value = GlobalErrorInfoException.class)
    @ResponseBody
    public void errorHandlerOverJson(HttpServletRequest request, HttpServletResponse response, GlobalErrorInfoException exception) {
        ErrorInfoInterface errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        ResponseUtils.write(response, result);
    }

    /**
     * Controller 顶级异常
     *
     * @param exception Exception
     * @return 要跳转得页面
     */
    @ExceptionHandler(value = Exception.class)
    // @ResponseBody
    public void errorHandlerOverJson(Exception exception, HttpServletResponse response) {
        exception.printStackTrace();
        Long errorCode = -1L;
        String message = "exception :接口异常，请查看后台日志";
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(errorCode);
        resultBody.setMessage(message);
        log.error("异常信息:{}", exception.getLocalizedMessage());
        log.error("异常信息:{},{}", exception.getMessage(), resultBody);
        ResponseUtils.write(response, resultBody);

    }

    /**
     * 用来处理bean validation异常
     * 请求参数异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({
            ConstraintViolationException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void resolveConstraintViolationException(ConstraintViolationException exception, HttpServletResponse response) {
        ResultBody resultBody = new ResultBody();
        Long errorCode = 5005L;
        String message = exception.getMessage();
        Object data = exception.getConstraintViolations();
        resultBody.setCode(errorCode);
        resultBody.setMessage(message);
        resultBody.setResult(data);
        log.error("异常信息:{}", exception.getLocalizedMessage());
        log.error("异常信息:{},{}", exception.getMessage(), resultBody);
        ResponseUtils.write(response, resultBody);
    }

}

