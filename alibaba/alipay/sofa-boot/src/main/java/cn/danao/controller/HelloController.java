package cn.danao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang
 * @version 1.0
 * @classname HelloController
 * @descriptionclass class describe
 * 1.****************
 * 2.****************
 * @createdate 2019/4/2
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class HelloController {

	@RequestMapping(value = "/hello")
	public String hello(){
		return "success";
	}

}
