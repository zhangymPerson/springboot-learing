package com.danao.util;

import com.danao.exception.ExceptionCode;
import com.danao.exception.SelfException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * date 2020/9/24 9:56 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
public class ValidatorUtil {

    public static Validator validator;

    @Resource
    public void setValidator(Validator validator) {
        ValidatorUtil.validator = validator;
    }


    public static void validate(Object bean, String beanName) {
        Errors errors = new BindException(bean, beanName);
        validator.validate(bean, errors);
        if (errors.hasErrors()) {
            String code = errors.getAllErrors().get(0).getCode();
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            if ("NotBlank".equalsIgnoreCase(code)) {
                throw new SelfException(ExceptionCode.PARAMS_NOT_NULL_INFO.fillArgs(message));
            } else {
                //参数异常
                throw new SelfException(ExceptionCode.PARAMS_ILLEGAL_INFO.fillArgs(message));
            }
        }
    }


    /**
     * 自定义正则验证
     *
     * @param data
     * @param regular
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void customCheck(String data, String regular, String errorMessage) {
        Pattern p = Pattern.compile(regular);
        Matcher m = p.matcher(data);
        if (!m.matches()) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }


    public static void isDate(String data, String errorMessage) {
        String pat = "\\d{4}-\\d{1,2}-\\d{1,2}";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(data);
        if (!m.matches()) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }

    /**
     * 正整数
     *
     * @param data
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void isPositiveInteger(String data, String errorMessage) {
        String pat = "^[1-9]\\d*$";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(data);
        if (!m.matches()) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }

    /**
     * 时间 hh:mm
     *
     * @param data
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void isTime(String data, String errorMessage) {
        String pat = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9])$";
        Pattern p = Pattern.compile(pat);
        Matcher m = p.matcher(data);
        if (!m.matches()) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }


    /**
     * 验证是否为空
     *
     * @param data
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void isBlank(String data, String errorMessage) {
        if (StringUtils.isEmpty(data)) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }

    /**
     * 验证是否为null
     *
     * @param data
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void isNULL(Object data, String errorMessage) {
        if (data == null) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }

    /**
     * 验证集合是否为空
     *
     * @param data
     * @param errorMessage
     * @author zc
     * @date 2020/8/24 10:09
     */
    public static void isEmpty(Collection data, String errorMessage) {
        if (data == null || data.isEmpty()) {
            log.error("错误数据 {} 异常信息 {}", data, errorMessage);
            throw new SelfException(ExceptionCode.DEFAULT);
        }
    }

}
