package cn.danao.springboot.springbootkotlin.dao

import cn.danao.springboot.springbootkotlin.bean.MemberInfo

interface MemberInfoDao {

    /**
     * 插入一个成员信息
     */
    fun insertMemberInfo(memberInfo: MemberInfo)

    /**
     * 获取一个成员信息
     */
    fun getMemberInfo(name: String): MemberInfo?

    /**
     * 获取所有成员信息
     */
    fun getAllMemberInfo(): MutableList<MemberInfo>
}