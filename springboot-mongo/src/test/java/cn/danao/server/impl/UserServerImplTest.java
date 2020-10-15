package cn.danao.server.impl;

import cn.danao.bean.SpringBootBaseTest;
import cn.danao.bean.User;
import cn.danao.dao.UserTwoDao;
import cn.danao.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class UserServerImplTest extends SpringBootBaseTest {


    @Autowired
    private UserServer userServer;

    @Autowired
    private UserTwoDao userTwoDao;

    @Test
    public void getUser() {
        User user = userServer.getUser("李四");
        log.info("user = {}", user);
    }

    @Test
    public void testUserTwoDao() {
        List<User> byAgeGreaterThan = userTwoDao.findByAgeGreaterThan(90);
        log.info("年龄大于90的用户有[{}]个，是[{}]", byAgeGreaterThan.size(), byAgeGreaterThan);
        List<User> byAgeLessThan = userTwoDao.findByAgeLessThan(5);
        log.info("年龄小于5的用户有[{}]个，是[{}]", byAgeLessThan.size(), byAgeLessThan);
        List<User> byUserIdBetween = userTwoDao.findByUserIdBetween(5, 10);
        log.info("userid 在5-10的用户有[{}]个，是[{}]", byUserIdBetween.size(), byUserIdBetween);
    }

}