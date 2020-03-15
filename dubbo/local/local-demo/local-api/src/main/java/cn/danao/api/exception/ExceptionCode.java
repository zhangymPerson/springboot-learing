package cn.danao.api.exception;

/**
 * date 2020/3/15 10:35 <br/>
 * descriptionclass <br/>
 * 异常处理状态枚举
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ExceptionCode {

    private Long code;

    private String msg;

    //通用的错误码
    public static ExceptionCode SUCCESS = new ExceptionCode(200L, "success");
    public static ExceptionCode FAIL = new ExceptionCode(500L, "false");
    public static ExceptionCode EXCEPTION_ERROR = new ExceptionCode(500L, "服务器运行异常");
    public static ExceptionCode EXCEPTION_INFO = new ExceptionCode(501L, "服务器运行异常,[%s]");

    private ExceptionCode(Long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionCode fillArgs(Object... args) {
        Long code = this.code;
        String message = String.format(this.msg, args);
        return new ExceptionCode(code, message);
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
