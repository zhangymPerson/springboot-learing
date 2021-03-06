package cn.danao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhang
 * @version 1.0
 * @classname HelloController
 * @descriptionclass
 * 1.****************
 * 2.****************
 * @createdate 2019/3/20
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping(value = "/hello", produces="application/json;charset=UTF-8")
	public String sayHello(){

		logger.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		logger.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		logger.error("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


		//double i 	=0.0;
		//i =3/0;
		return "测试中文字符 !";
	}

	@GetMapping(value = "/test")
	public String test(){
		logger.info("请求/test");
			return "测试中文内容";
	}


}
