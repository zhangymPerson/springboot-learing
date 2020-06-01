package cn.danao.controller;

import cn.danao.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/6/1 15:00 <br/>
 * description class <br/>
 * 测试请求
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/drools")
@Slf4j
public class UserController {

    @Autowired
    private UserServer userServer;

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping(value = "/test")
    public String test() {
        log.info("test");
        userServer.getUser();
        return "ok";
    }

}
