package cn.danao.controller;

import cn.danao.bean.User;
import cn.danao.common.exception.SelfException;
import cn.danao.common.result.ErrorCode;
import cn.danao.common.result.Result;
import cn.danao.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static cn.danao.common.result.Result.success;

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
@RequestMapping("/user")
public class HelloController {

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/hello")
	public String sayHello(){
		return "hello word!";
	}

	/**
	 * get请求可以使用@GetMapping 注解
	 * @return
	 */
	@GetMapping(value = "/getall")
	public Result test(){
		//List<User> list = new ArrayList<>();
		List list = userDao.getAllUser();
		if(list == null || list.isEmpty()){
			//throw new SelfException(ErrorCode.COMMON_SERVER_ERROR);
			return Result.error(ErrorCode.COMMON_SERVER_ERROR);
		}
		System.out.println(list.get(0));
		return Result.success(list);
	}

}
