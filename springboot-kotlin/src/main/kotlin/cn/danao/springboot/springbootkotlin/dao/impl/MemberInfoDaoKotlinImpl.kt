package cn.danao.springboot.springbootkotlin.dao.impl

import cn.danao.springboot.springbootkotlin.bean.MemberInfo
import cn.danao.springboot.springbootkotlin.dao.MemberInfoDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

/**
 * kotlin调用mongoTemplate
 */
@Service(value = "memberInfoDaoKotlin")
class MemberInfoDaoKotlinImpl : MemberInfoDao {

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    override fun insertMemberInfo(memberInfo: MemberInfo) {
        mongoTemplate.insert(memberInfo)
    }

    override fun getMemberInfo(name: String): MemberInfo? {
        return null
    }

    override fun getAllMemberInfo(): MutableList<MemberInfo> {
        return mongoTemplate.findAll(MemberInfo::class.java)
    }
}