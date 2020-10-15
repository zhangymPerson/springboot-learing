package cn.danao.test;

import cn.danao.bean.SpringBootBaseTest;
import cn.danao.bean.User;
import cn.danao.dao.UserDao;
import cn.danao.dao.UserTwoDao;
import cn.danao.util.NameUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname SpringTest
 * @descriptionclass 1.测试mongo操作的各种类型
 * 2.其他说明
 * @createdate 2019/6/19 10:05
 * @since 1.0
 */
@Slf4j
public class SpringTest extends SpringBootBaseTest {

    @Autowired
    UserDao userDao;

    @Autowired
    UserTwoDao userTwoDao;

    public User getUser() {
        User user = new User();
        String id = String.valueOf(new Date().getTime());
        log.info(id);
        user.setUserId(id);
        user.setCreateDate(new Date());
        user.setName("张三");
        user.setAge(18);
        log.info("user {}", user);
        return user;
    }

    @Test
    public void testUserDao() {
        User user = getUser();
        //
        userDao.insert(user);
        User u = userDao.findById("1560910672510");
        log.info("{}", u);
    }

    @Test
    public void testUserDaoTest() {
        User user = getUser();
        //插入
        userTwoDao.insert(user);
        log.info("修改前:{}", userTwoDao.findById(user.userId));
        //修改
        user.setName("修改后的名字");
        userTwoDao.save(user);
        log.info("修改后:{}", userTwoDao.findById(user.userId));
        //删除
        userTwoDao.deleteById(user.userId);
        //查询全部
        List<User> list = userTwoDao.findAll();
        log.info("{}", list);
    }

    /**
     * 构造测试用户数据
     */
    @Test
    public void addTestData() {
        int num = 100;
        for (int i = 0; i < num; i++) {
            User user = new User();
            user.setUserId(String.valueOf(i));
            user.setName(NameUtil.build());
            user.setAge(i);
            user.setCreateDate(new Date());
            userTwoDao.save(user);
        }
    }
}
