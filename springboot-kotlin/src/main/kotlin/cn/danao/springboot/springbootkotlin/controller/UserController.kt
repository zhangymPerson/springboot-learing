package cn.danao.springboot.springbootkotlin.controller

import cn.danao.springboot.springbootkotlin.server.UserServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userServerJava: UserServer

    @Autowired
    lateinit var userServerKotlin: UserServer

    /**
     * http://127.0.0.1:8080/user/java/get?id=1
     */
    @GetMapping("/java/get")
    fun getJavaOneUser(id: Int): String {
        println("调用java,查询的id=" + id)
        return userServerJava.getUserOneById(id).toString()
    }

    /**
     * http://127.0.0.1:8080/user/kotlin/get?id=1
     */
    @GetMapping("/kotlin/get")
    fun getKotlinOneUser(id: Int): String {
        println("调用kotlin,查询的id=" + id)
        return userServerKotlin.getUserOneById(id).toString()
    }
}