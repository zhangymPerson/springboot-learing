package cn.danao.springbootshiro.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname TestController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/10/12 17:09
 * @since 1.0
 */
@Slf4j
@RestController()
@RequestMapping(value = "/test")
public class TestController {
    /**
     * 测试项目是否启动
     *
     * @return
     */
    @RequestMapping(value = "/success")
    public String isStart() {
        log.info("测试项目是否启动");
        Map<String, Object> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "测试成功");
        return JSON.toJSONString(result);
    }

}
