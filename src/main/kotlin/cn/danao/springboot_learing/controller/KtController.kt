package cn.danao.springboot_learing.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kt")
open class KtController {

    // 定义一个方法 返回 hello world
    @RequestMapping("/hello")
    fun hello(): String {
        return "hello world"
    }

}