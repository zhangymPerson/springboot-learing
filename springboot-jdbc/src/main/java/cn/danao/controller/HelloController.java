package cn.danao.controller;

import cn.danao.bean.User;
import cn.danao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang
 * @version 1.0
 * @classname HelloController
 * @descriptionclass 1.****************
 * 2.****************
 * @createdate 2019/3/19
 * @since 1.0
 */
@RestController
public class HelloController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/hello")
	public String sayHello(){
		return "hello word!";
	}

	@RequestMapping(value = "/test")
	public String test(){

		List<User> list = new ArrayList<>();
		list = userDao.getAllUser();
		System.out.println(list.get(0));
		return "success";

	}

}
