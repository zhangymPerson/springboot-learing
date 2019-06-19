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
 * @descriptionclass
 * 1.mongo类的测试请求
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
        //测试专用
        User user = getUser();
        userDaoTest.insert(user);
        return "test";
    }

    /**
     * 根据时间作为id生成用户，避免插入报错
     * @return
     */
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

}
