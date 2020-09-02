package cn.danao.springboot.springbootkotlin.controller

import cn.danao.springboot.springbootkotlin.bean.UserOne
import cn.danao.springboot.springbootkotlin.bean.UserTwo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/say")
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
        var user = UserOne()
        user.userName = "张三"
        user.remark = "备注"
        var usertwo = UserTwo()
        //私有化set方法 公有化public注解可以赋值
        usertwo.name = "hello"
        usertwo.other = "你猜"
        println(user.toString() + " " + usertwo.toString())
        return "Hi"
    }
}

