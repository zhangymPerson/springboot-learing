package cn.danao.exception;

/**
 * @author danao
 * @version 1.0
 * @classname GlobalException
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/31 11:00
 * @since 1.0
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 自定义异常
     */
    private CodeMsg codeMsg;

    public GlobalException(String exceptionStr) {
        super(exceptionStr);
    }

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        System.out.println(cm.toString());
        this.codeMsg = cm;
    }

    public GlobalException(CodeMsg cm, Exception ex) {
        super(cm.toString());
        this.codeMsg = cm;
        this.codeMsg.setMsg(this.codeMsg.getMsg() + "\\r\\n" + ex.getMessage());
    }

    public CodeMsg getCm() {
        return codeMsg;
    }
}
