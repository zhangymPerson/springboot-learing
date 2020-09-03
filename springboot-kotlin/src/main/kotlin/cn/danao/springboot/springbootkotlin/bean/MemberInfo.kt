package cn.danao.springboot.springbootkotlin.bean

import org.springframework.data.mongodb.core.mapping.Document

/**
 * 成员信息表
 */
@Document(value = "member_info")
class MemberInfo {
    lateinit var name: String

    var street: String
        get() {
            return street
        }
        set(value) {}
    var city: String = ""
    var state: String? = null

    override fun toString(): String {
        return "MemberInfo(name='$name', city='$city', state=$state)"
    }

}