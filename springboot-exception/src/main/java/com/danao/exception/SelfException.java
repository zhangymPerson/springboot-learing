package com.danao.exception;

/**
 * @author danao
 * @version 1.0
 * @classname SelfException
 * @descriptionclass
 * 1.自定义异常测试类
 * @createdate 2019/5/23 10:19
 * @since 1.0
 */
public class SelfException  extends RuntimeException{

    private static final long serialVersionUID = 1L;

    /**
     * 自定义异常
     */
    private ExceptionCode exceptionCode;

    public SelfException(String exceptionStr){
        super(exceptionStr);
    }

    public SelfException(ExceptionCode cm) {
        super(cm.toString());
        System.out.println(cm.toString());
        this.exceptionCode = cm;
    }

    public SelfException(ExceptionCode cm, Exception ex) {
        super(cm.toString());
        this.exceptionCode = cm;
        this.exceptionCode.setMsg(this.exceptionCode.getMsg() + "\\r\\n" + ex.getMessage());
    }

    public ExceptionCode getCm() {
        return exceptionCode;
    }


}
