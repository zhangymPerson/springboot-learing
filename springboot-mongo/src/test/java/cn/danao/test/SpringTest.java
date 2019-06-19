package cn.danao.test;

import cn.danao.bean.SpringBootBaseTest;
import cn.danao.bean.User;
import cn.danao.dao.UserDao;
import cn.danao.dao.UserDaoTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname SpringTest
 * @descriptionclass
 * 1.测试mongo操作的各种类型
 * 2.其他说明
 * @createdate 2019/6/19 10:05
 * @since 1.0
 */
@Slf4j
public class SpringTest extends SpringBootBaseTest {

    @Autowired
    UserDao userDao;

    @Autowired
    UserDaoTest userDaoTest;

    public User getUser(){
        User user = new User();
        String id = String.valueOf(new Date().getTime());
        log.info(id);
        user.setUserId(id);
        user.setCreateDate(new Date());
        user.setName("测试人员");
        user.setAge(18);
        log.info("user {}",user);
        return user;
    }

    @Test
    public void testUserDao(){
        User user = getUser();
        //
        userDao.insert(user);
        User u = userDao.findById("1560910672510");
        log.info("{}",u);
    }

    @Test
    public void testUserDaoTest(){
        User user = getUser();
        //插入
        userDaoTest.insert(user);
        log.info("修改前:{}",userDaoTest.findById(user.userId));
        //修改
        user.setName("修改后的名字");
        userDaoTest.save(user);
        log.info("修改后:{}",userDaoTest.findById(user.userId));
        //删除
        userDaoTest.deleteById(user.userId);
        //查询全部
        List<User> list = userDaoTest.findAll();
        log.info("{}",list);
    }

}
