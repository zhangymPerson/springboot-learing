package cn.danao.springboot_learing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2024/8/5 16:44 <br/>
 * description class PingController<br/>
 *
 * @author zym
 */
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

}
