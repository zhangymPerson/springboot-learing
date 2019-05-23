package com.danao.exception;

/**
 * @author danao
 * @version 1.0
 * @classname EeceptionCode
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/23 10:09
 * @since 1.0
 */
public class ExceptionCode {

    public static ExceptionCode DEFAULT = new ExceptionCode();
    public static ExceptionCode BYZERO = new ExceptionCode(101,"除数不能为0");
    public static ExceptionCode SELF = new ExceptionCode(111,"自定义异常");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExceptionCode(){
        this.code=100;
        this.msg="未知错误";
    }

    public ExceptionCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
