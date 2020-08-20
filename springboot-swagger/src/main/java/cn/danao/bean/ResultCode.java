package cn.danao.bean;

/**
 * date 2020/8/19 17:23 <br/>
 * description class <br/>
 * 返回对象包装类
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ResultCode {

    /**
     * 状态码
     * 成功 = 200
     * 失败 = 其他异常情况
     */
    private int code;
    /**
     * 结果说明
     * 成功 = success
     * 失败 = 其他异常情况
     */
    private String message;

    /**
     * 返回结果数据
     */
    private Object result;

    private ResultCode() {
        super();
    }

    public static ResultCode SUCCESS = new ResultCode(null);

    public static ResultCode ERROR = new ResultCode(500, "fail", null);

    private ResultCode(Object object) {
        this.code = 200;
        this.message = "success";
        this.result = object;
    }

    public ResultCode(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }

    public static ResultCode resultCode(Object object) {
        return new ResultCode(200, "success", object);
    }
}
