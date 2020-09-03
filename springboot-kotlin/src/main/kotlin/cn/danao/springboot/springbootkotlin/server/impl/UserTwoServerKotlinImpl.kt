package cn.danao.springboot.springbootkotlin.server.impl

import cn.danao.springboot.springbootkotlin.bean.UserTwo
import cn.danao.springboot.springbootkotlin.server.UserTwoServer
import org.springframework.stereotype.Service


@Service("userTwoServerKotlin")
class UserTwoServerKotlinImpl : UserTwoServer {
    var list: MutableList<UserTwo> = mutableListOf(UserTwo("1", "other1"),
            UserTwo("2", "other2"),
            UserTwo("3", "other3"),
            UserTwo("4", "other4"))

    override fun getUserTwo(id: Int): UserTwo {
        println("请求的UserTwoServerKotlinImpl,请求的id是" + id)
        return list.get(id - 1)
    }

    override fun getAllUserTwo(): MutableList<UserTwo> {
        println("请求的UserTwoServerKotlinImpl,获取全部成员")
        return list
    }
}