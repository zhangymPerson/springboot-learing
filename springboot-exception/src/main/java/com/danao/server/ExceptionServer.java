package com.danao.server;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname ExceptionServer
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/25 12:02
 * @since 1.0
 */
public interface ExceptionServer {

    Map<String, Object> exceptionMethod(Map<String, Object> params);

}
