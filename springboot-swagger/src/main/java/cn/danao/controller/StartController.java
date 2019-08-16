package cn.danao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname StartController
 * @descriptionclass 1.测试项目启动
 * 2.其他说明
 * @createdate 2019/7/30 17:18
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/start")
@Slf4j
public class StartController {


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
        return result.toString();
    }


    /**
     * 测试get   请求参数
     * 需要两个参数 params:value 和 num:数字 类型与后台代码一致
     *
     * @param argOne
     * @param argTwo
     * @return
     */
    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public String isParams(@RequestParam String argOne, @RequestParam int argTwo) {
        log.info("请求的是参数测试接口，请求参数 [ {} {} ]", argOne, argTwo);
        Map<String, Object> params = new HashMap<>();
        params.put("status", 200);
        params.put("msg", "success");
        params.put("result", "请求参数，argOne = " + argOne + ",argTwo = " + argTwo);
        return params.toString();
    }

    /**
     * post发送json请求的测试接口
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/params/post/json", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public String isParamsPostJson(@RequestBody Map<String, Object> params) {
        log.info("请求的是参数测试接口，请求参数 [{}]", params);
        params.put("status", "200");
        params.put("msg", "测试成功");
        return params.toString();
    }

    /**
     * post发送json请求的测试接口
     *
     * @param argOne
     * @param argTwo
     * @return
     */
    @RequestMapping(value = "/params/post", method = RequestMethod.POST)
    public String isParamsPost(@RequestParam String argOne, @RequestParam String argTwo) {
        log.info("请求的是参数测试接口，请求参数 [{} {}]", argOne, argTwo);
        Map<String, Object> params = new HashMap<>();
        params.put("status", "200");
        params.put("msg", "测试成功" + "参数" + argOne + "," + argTwo);
        return params.toString();
    }

}
