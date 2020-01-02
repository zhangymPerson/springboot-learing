package cn.danao.springbootshiro.controller;

import cn.danao.springbootshiro.bean.User;
import cn.danao.springbootshiro.server.TokenServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2019/12/31 17:27 <br/>
 * descriptionclass <br/>
 * Token 请求测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/token")
@Slf4j
public class TokenController {


    private TokenServer tokenServer;

    public TokenController(TokenServer tokenServer) {
        this.tokenServer = tokenServer;
    }

    @RequestMapping(value = "/user/{username}/{password}", method = RequestMethod.GET)
    public String getUserToken(@PathVariable("username") String username, @PathVariable("password") String password) {
        log.info("获取token的用户信息 username {} password {} ", username, password);
        User user = new User("1", username, password);
        return tokenServer.getUserToken(user);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String getUserToken(String token) {
        log.info("获取token的用户信息 token {} ", token);
        tokenServer.checkToken(token);
        return "success";
    }

}
