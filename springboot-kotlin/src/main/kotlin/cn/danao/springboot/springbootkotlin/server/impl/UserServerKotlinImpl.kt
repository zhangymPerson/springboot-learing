package cn.danao.springboot.springbootkotlin.server.impl

import cn.danao.springboot.springbootkotlin.bean.UserOne
import cn.danao.springboot.springbootkotlin.server.UserServer
import org.springframework.stereotype.Service

/**
 * kotlin 实现 java接口
 * 语法 class ClassName : InterfaceName {}
 */
@Service(value = "userServerKotlin")
class UserServerKotlinImpl : UserServer {

    fun createUserOne(): MutableList<UserOne> {
        var list: MutableList<UserOne> = mutableListOf()
        var a = UserOne()
        a.id = 1
        a.userName = "name"
        var b = UserOne()
        b.id = 2
        b.userName = "bname"
        var c = UserOne()
        c.id = 3
        list.add(a)
        list.add(b)
        list.add(c)
        return list
    }


    override fun getUserOneById(userId: Int?): UserOne {
        println("调用kotlin代码查询id=" + userId)
        return createUserOne().get(0)
    }

    override fun getAllUserOne(): MutableList<UserOne> {
        //TODO("Not yet implemented")
        println("调用kotlin代码查询全部")
        return createUserOne()
    }

}