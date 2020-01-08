package cn.danao.springbootshiro.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/1/8 11:49 <br/>
 * description class <br/>
 * 返回数据对象封装
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Data
public class ResultCode<T> {

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 400;

    private static final String MSG_SUCCESS = "success";
    private static final String MSG_FAIL = "failed";

    private int code;
    private T data;
    private String msg;

    public ResultCode() {
    }

    public ResultCode(int code) {
        this.code = code;
    }

    public ResultCode(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCode(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultCode success() {
        return new ResultCode(CODE_SUCCESS, MSG_SUCCESS);
    }

    public static ResultCode success(Object data) {
        return new ResultCode(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    public static ResultCode fail() {
        return new ResultCode(CODE_FAIL, MSG_FAIL);
    }

}
