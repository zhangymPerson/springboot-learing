package com.danao.server.impl;

import com.danao.exception.ExceptionCode;
import com.danao.exception.SelfException;
import com.danao.server.ExceptionServer;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname ExceptionServerImpl
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/25 12:03
 * @since 1.0
 */
@Service
public class ExceptionServerImpl implements ExceptionServer {
    @Override
    public Map<String, Object> exceptionMethod(Map<String, Object> params) {
        try {
            String s = "aaaa";
            int i = Integer.valueOf(s);
            return null;
        } catch (Exception e) {
            throw new SelfException(ExceptionCode.SELF_INFO.fillClassNameArgs(this.getClass(), e.getMessage()));
        }
    }
}
