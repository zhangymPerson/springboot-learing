package cn.danao.controller;

import cn.danao.annotation.LogNote;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danao
 * @version 1.0
 * @classname LogController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/27 15:13
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/log")
public class LogController {

    @LogNote(cla = LogController.class,value = "测试注解",info = "请求路由/log/test")
    @RequestMapping(value = "/test")
    public String testAnnotation(){
        return "测试成功!";
    }

}
