package cn.danao.springboot.springbootkotlin.dao.impl;

import cn.danao.springboot.springbootkotlin.bean.MemberInfo;
import cn.danao.springboot.springbootkotlin.dao.MemberInfoDao;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * date 2020/9/3 11:05 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service(value = "memberInfoDaoJava")
public class MemberInfoDaoImpl implements MemberInfoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @NotNull
    @Override
    public void insertMemberInfo(@NotNull MemberInfo memberInfo) {
        mongoTemplate.save(memberInfo);
    }

    @NotNull
    @Override
    public MemberInfo getMemberInfo(@NotNull String name) {

        return null;
    }

    @NotNull
    @Override
    public List<MemberInfo> getAllMemberInfo() {
        List<MemberInfo> all = mongoTemplate.findAll(MemberInfo.class);
        return all;
    }
}
