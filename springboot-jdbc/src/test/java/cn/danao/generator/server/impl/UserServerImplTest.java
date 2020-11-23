package cn.danao.generator.server.impl;

import cn.danao.generator.model.User;
import cn.danao.generator.server.UserServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServerImplTest {

    @Autowired
    private UserServer userServer;

    @Test
    public void add() {
        User user = new User();
        user.setPid(202);
        user.setAccount("");
        user.setEmail("123@123.com");
        user.setPassword("");
        user.setName("测试");
        user.setIntegrity((byte) 0);
        userServer.add(user);
    }
}