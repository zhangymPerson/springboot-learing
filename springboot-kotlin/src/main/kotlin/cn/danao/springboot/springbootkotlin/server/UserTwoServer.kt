package cn.danao.springboot.springbootkotlin.server

import cn.danao.springboot.springbootkotlin.bean.UserTwo

/**
 * kotlin定义接口
 *
 */
interface UserTwoServer {
    /**
     * 根据id获取用户
     */
    fun getUserTwo(id: Int): UserTwo

    fun getAllUserTwo(): MutableList<UserTwo>
}