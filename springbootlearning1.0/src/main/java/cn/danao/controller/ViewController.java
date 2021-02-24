package cn.danao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

    /**
     * 服务地址
     */
    @Value("${project.local.ip}")
    private String ip;

    /**
     * 端口
     */
    @Value("${server.port}")
    private String port;

    /**
     * 配置的前置路由地址
     */
    @Value("${server.servlet.context-path}")
    private String path;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("real_ip", getRealIP());
        map.addAttribute("ip", ip);
        map.addAttribute("port", port);
        map.addAttribute("path", path);
        return "index";
    }

    public String getRealIP() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
    }

}
