package cn.danao.springboot.springbootkotlin.dao.impl;

import cn.danao.springboot.springbootkotlin.SpringbootKotlinApplicationTests;
import cn.danao.springboot.springbootkotlin.bean.MemberInfo;
import cn.danao.springboot.springbootkotlin.dao.MemberInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
class MemberInfoDaoImplTest extends SpringbootKotlinApplicationTests {

    @Autowired
    private MemberInfoDao memberInfoDaoJava;

    @Test
    void insertMemberInfo() {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setName("成员名" + LocalDateTime.now());
        memberInfo.setCity("北京");
        memberInfoDaoJava.insertMemberInfo(memberInfo);
    }

    @Test
    void getMemberInfo() {
    }

    @Test
    void getAllMemberInfo() {
        List<MemberInfo> allMemberInfo = memberInfoDaoJava.getAllMemberInfo();
        log.info("获取到的所有成员是[{}]", allMemberInfo);
    }
}