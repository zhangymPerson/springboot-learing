package com.danao.server;

import org.springframework.stereotype.Service;

/**
 * @author danao
 * @version 1.0
 * @classname HelloServer
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/23 10:52
 * @since 1.0
 */
@Service
public class HelloServer {

    public int getInt() {
        double i = 1;
        i = 1 / 0;
        return 2;
    }

}
