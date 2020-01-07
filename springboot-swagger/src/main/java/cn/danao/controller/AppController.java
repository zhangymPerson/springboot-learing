package cn.danao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2020/1/7 17:09 <br/>
 * descriptionclass <br/>
 * <p>
 * 注解没有路由地址会覆盖swaggerl路径 请求不到swagger-ui.html
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RestController
public class AppController {

    /**
     * 直接使用 @RequestMapping 可以避免出现空白提示页 但是swagger-ui.html页面请求不到 /v2/api-docs 可以
     *
     * 其中 @RequestMapping(value = "") 可以显示swagger-ui.html页面，但是无法替换空白页
     * @return 提示内容
     */
    @RequestMapping(value = "")
    public String info() {
        return "url not exist";
    }

}
