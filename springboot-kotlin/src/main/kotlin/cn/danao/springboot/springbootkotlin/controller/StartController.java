package cn.danao.springboot.springbootkotlin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/9/2 17:39 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/start")
@Slf4j
public class StartController {

    /**
     * http://127.0.0.1:8080/start/test?key=key
     *
     * @param key
     * @return
     */
    @GetMapping(value = "/test")
    public String start(String key) {
        log.info("传入参数={}", key);
        String result = "{\n" +
                "  \"status\": true\n" +
                "}";
        return result;
    }

}
