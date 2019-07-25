package com.danao.bean;

import java.util.Stack;

/**
 * @author danao
 * @version 1.0
 * @classname ResultCode
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/25 11:25
 * @since 1.0
 */
public class ResultCode {

    private Long code;
    private String msg;
    private Object result;

    public static ResultCode SUCCESS = new ResultCode(200L,"success","success");

    public static ResultCode FAIL = new ResultCode(500L,"fail","fail");

    private ResultCode() {
    }

    private ResultCode(Long code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.result = object;
    }

    private ResultCode(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object object) {
        this.result = object;
    }

    public static ResultCode getResult(Object object){
        if(object == null){
            return new ResultCode(200L,"succsee","");
        }
        return new ResultCode(200L,"success",object);
    }

}
