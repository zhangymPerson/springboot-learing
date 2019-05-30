package cn.danao.controller;

import cn.danao.bean.User;
import cn.danao.dao.UserDao;
import cn.danao.dao.UserDaoTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author danao
 * @version 1.0
 * @classname UserController
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/30 15:21
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserDaoTest userDaoTest;


    @RequestMapping(value = "/test")
    public String test(){
        return "success";
    }


    @RequestMapping(value = "/mongo")
    public String mongoTest(){
        log.info("/mongo");
        User user = new User();
        user.setUserId("1234");
        user.setCreateDate(new Date());
        user.setName("steestr");
        userDao.insert(user);
        user.setUserId("12345");
        user.setCreateDate(new Date());
        userDaoTest.insert(user);
        return "test";
    }

}
