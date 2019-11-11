package cn.danao.kotlin_project.controller

import cn.danao.kotlin_project.server.StartServer
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

@RestController
//kotlin目前不能使用@Slfj注解
//@Slf4j
@RequestMapping(value = ["/start"])
class StartController {


    @Resource
    lateinit var startServer: StartServer;
    var s : Any = startServer.getSum(12,21)

    //创建日志
    var log = LoggerFactory.getLogger(this.javaClass);

    @RequestMapping(value = ["/test"])
    fun testRequest(name: String): String {
        log.info("name = ${name}")
        println("name = ${name}")
        var sum = startServer.getSum(12, 14)
        var test = startServer.interfaceTest();
        log.info("sum = ${sum}, test = ${test}")
        return "测试"
    }

}