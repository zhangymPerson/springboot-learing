package cn.danao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author danao
 * @version 1.0
 * @classname ViewController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/28 16:14
 * @since 1.0
 */
@Controller
@Slf4j
@RequestMapping(value = "/view")
public class ViewController {


    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}
