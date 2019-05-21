package cn.danao.aop;


import cn.danao.util.ResponseUtils;
import cn.danao.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 切 ApiErrorInfoException 异常
     * @param exception ApiErrorInfoException
     * @param response HttpServletResponse
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
        ResponseUtils.write(response,resultBody);
    }

    /**
     * 切 GlobalErrorInfoException 异常
     * @param exception ApiErrorInfoException
     * @param request HttpServletRequest
     * @return ResultBody
     */
    @ExceptionHandler(value = GlobalErrorInfoException.class)
    @ResponseBody
    public void errorHandlerOverJson(HttpServletRequest request, HttpServletResponse response,GlobalErrorInfoException exception) {
        ErrorInfoInterface errorInfo = exception.getErrorInfo();
        ResultBody result = new ResultBody(errorInfo);
        ResponseUtils.write(response,result);
    }

    /**
     * Controller 顶级异常
     * @param exception Exception
     * @return 要跳转得页面
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void errorHandlerOverJson(Exception exception, HttpServletResponse response) {
        Long errorCode = -1L;
        String message = "接口异常，请查看后台日志";
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(errorCode);
        resultBody.setMessage(message);
        LOGGER.error("异常信息:{}",exception.getMessage());
        ResponseUtils.write(response,resultBody);
    }
}

