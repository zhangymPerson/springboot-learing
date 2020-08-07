package cn.danao.api.exception;

/**
 * date 2020/3/15 8:41 <br/>
 * descriptionclass <br/>
 * 自定义项目异常
 * 公有异常处理
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ApiRunException extends RuntimeException {

    private ExceptionCode exceptionCode;

    public ApiRunException(ExceptionCode cm) {
        super(cm.toString());
        System.out.println(cm.toString());
        this.exceptionCode = cm;
    }

    public ApiRunException(ExceptionCode cm, Exception ex) {
        super(cm.toString());
        this.exceptionCode = cm;
        this.exceptionCode.setMsg(this.exceptionCode.getMsg() + "\\r\\n" + ex.getMessage());
    }

    public ExceptionCode getCm() {
        return exceptionCode;
    }
}
