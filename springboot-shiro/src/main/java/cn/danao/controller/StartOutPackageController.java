package cn.danao.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * create date 2019/10/12 16:57
 * description class 1.测试请求类
 * 当controller 不在 启动类的目录下的子包时，需要在启动类中添加注解
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@RestController()
@RequestMapping(value = "outstart")
public class StartOutPackageController {


    /**
     * 测试项目是否启动
     *
     * @return
     */
    @RequestMapping(value = "/success")
    public String isStart() {
        log.info("请求的是 {} 测试项目是否启动", this.getClass().getName());
        log.info("测试非启动类子包下的注解生效 需配置启动类扫描包包含当前包");
        Map<String, Object> result = new HashMap<>();
        result.put("status", "200");
        result.put("msg", "测试成功");
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/request/test", method = RequestMethod.POST)
    public String testRequest() {
        return "success";
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
        return JSON.toJSONString(params);
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
        return JSON.toJSONString(params);
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
        return JSON.toJSONString(params);
    }

}
