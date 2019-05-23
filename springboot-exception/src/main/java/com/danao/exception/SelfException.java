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

    public SelfException(){
        super();
    }

    public SelfException(String exceptionInfo){
        super(exceptionInfo);
    }

}
