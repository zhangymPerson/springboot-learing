package cn.danao.springbootshiro.controller;

import cn.danao.springbootshiro.bean.ResultCode;
import cn.danao.springbootshiro.bean.User;
import cn.danao.springbootshiro.server.TokenServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/1/8 11:39 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@Slf4j
public class LoginController {

    private TokenServer tokenServer;

    @Autowired
    public LoginController(TokenServer tokenServer) {
        this.tokenServer = tokenServer;
    }

    @PostMapping(value = "/login")
    public ResultCode login(@RequestBody User user) {
        log.info("User {}", user);
        String token = tokenServer.getUserToken(user);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return ResultCode.success(map);
    }

    @GetMapping(value = "/token")
    public ResultCode token(String token) {
        log.info("token", token);
        tokenServer.checkToken(token);
        return ResultCode.success("token is right");
    }

}
