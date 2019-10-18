package com.danao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author danao
 * @version 1.0
 * @classname PostParamController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/10/18 15:00
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/post")
@Slf4j
public class PostParamController {

    /**
     * 测试参数
     * 不添加任何注释的参数 下例中的 id
     * 请求在 Params可读取到
     * 请求在 body 中的 form-data中可以读取到
     *  多个同名的参数会以list的形式接收
     * @return
     */
    @RequestMapping(value = "/one",method = RequestMethod.POST)
    //@PostMapping(value = "/tests")
    public String testParams(String id) {
        log.info("请求的参数 {}", id);
        return id;
    }

    /**
     * 与传一个参数类似，
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/two",method = RequestMethod.POST)
    public String testParms(String id,String name){
        log.info("{} {}",id,name);
        return "success";
    }

    /**
     * 测试读取json请求的参数
     * id代表整个json串,指的时整个参数
     * @return
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST,consumes = "application/json")
    public String testJsonParams(@RequestBody String id){
        log.info("读取json中参数 id {} ",id);
        return id;
    }


}
