package cn.danao.springboot.springbootkotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("say")
class HelloController {


    @GetMapping("/hello")
    fun sayHello(): Map<String, String> {
        /**
         * 创建map的方式
         */
        var map = hashMapOf<String, String>()
        map.put("test", "test")
        return map
    }

    /**
     * 请求路由 http://127.0.0.1:8080/say/hi
     */
    @GetMapping("hi")
    fun sayHi(): String {
        return "Hi"
    }
}

