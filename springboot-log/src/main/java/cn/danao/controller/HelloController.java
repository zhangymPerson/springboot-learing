package cn.danao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang
 * @version 1.0
 * @classname HelloController
 * @descriptionclass 1.****************
 * 2.****************
 * @createdate 2019/3/20
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class HelloController {

	@GetMapping("/helloword")
	public String sayHello(){
		return "Hello word !";
	}




}
