package cn.danao.kotlin_project.controller

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
//kotlin目前不能使用@Slfj注解
//@Slf4j
@RequestMapping(value = ["/start"])
class StartController {

    //创建日志
    var log = LoggerFactory.getLogger(this.javaClass);
    @RequestMapping(value = ["/test"])
    fun testRequest(name: String): String {
        log.info("name = ${name}")
        println("name = ${name}")
        return "测试"
    }

}