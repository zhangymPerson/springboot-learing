package cn.danao.springboot.springbootkotlin.controller

import cn.danao.springboot.springbootkotlin.server.UserServer
import cn.danao.springboot.springbootkotlin.server.UserTwoServer
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

    @Autowired
    lateinit var userTwoServerJava: UserTwoServer

    @Autowired
    lateinit var userTwoServerKotlin: UserTwoServer

    /**
     * http://127.0.0.1:8080/user/java/get?id=1
     */
    @GetMapping("/java/get")
    fun getJavaOneUser(id: Int): String {
        println("调用java,查询的id=" + id)
        var allUserOne = userServerJava.getAllUserOne()
        println("获取到所有成员是" + allUserOne)
        return userServerJava.getUserOneById(id).toString()
    }

    /**
     * http://127.0.0.1:8080/user/kotlin/get?id=1
     */
    @GetMapping("/kotlin/get")
    fun getKotlinOneUser(id: Int): String {
        println("调用kotlin,查询的id=" + id)
        var allUserOne = userServerKotlin.getAllUserOne()
        println("获取到所有成员是" + allUserOne)
        return userServerKotlin.getUserOneById(id).toString()
    }

    /**
     * http://127.0.0.1:8080/user/java2/get?id=1
     */
    @GetMapping("/java2/get")
    fun getJavaUserTwo(id: Int): String {
        println("调用java,查询的id=" + id)
        var allUserTwo = userTwoServerJava.getAllUserTwo()
        println("获取到的用户列表是" + allUserTwo)
        return userTwoServerJava.getUserTwo(id).toString()
    }

    /**
     * http://127.0.0.1:8080/user/kotlin2/get?id=1
     */
    @GetMapping("/kotlin2/get")
    fun getKotlinTwoUser(id: Int): String {
        println("调用kotlin,查询的id=" + id)
        var allUserTwo = userTwoServerKotlin.getAllUserTwo()
        println("获取到的所有成员是${allUserTwo}")
        return userTwoServerKotlin.getUserTwo(id).toString()
    }

}
