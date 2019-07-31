package cn.danao.exception;

/**
 * @author danao
 * @version 1.0
 * @classname ExceptionCode
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 11:01
 * @since 1.0
 */
public class ExceptionCode {
    public static ExceptionCode DEFAULT = new ExceptionCode();
    public static ExceptionCode BYZERO = new ExceptionCode(501, "除数不能为0");
    public static ExceptionCode EXCEPTION = new ExceptionCode(511, "自定义异常");
    public static ExceptionCode EXCEPTION_INFO = new ExceptionCode(510, "自定义异常，异常信息：%s");

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

    private ExceptionCode() {
        this.code = 500;
        this.msg = "未知错误";
    }

    private ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionCode fillArgs(String... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new ExceptionCode(code, message);
    }

    public ExceptionCode fillClassNameArgs(Class classObject, String... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        String msg = String.format("异常类:%s,异常信息:%s", classObject.getName(), message);
        return new ExceptionCode(code, msg);
    }
}
