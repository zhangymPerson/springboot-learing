package cn.danao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
@RequestMapping(value = "/test")
@RestController
public class HelloController {


	@Autowired
	RedisTemplate<String,String> redisTemplate;

	@RequestMapping(value = "/hello")
	public String sayHello(){
		return "hello word";
	}

	@RequestMapping(value = "/redis")
	public String test(){
		//模拟数据
		Map<String,String> user = new HashMap<String, String>();
		user.put("1","zhangsan");
		System.out.println("redis存储数据");
		redisTemplate.opsForValue().set("a","b");
		redisTemplate.opsForValue().set("aa","b");
		redisTemplate.opsForValue().set("aaa","b");
		redisTemplate.opsForValue().set("aaa","b");
		redisTemplate.opsForValue().set("aaaa","b");
		redisTemplate.opsForValue().set("1a","b");
		redisTemplate.opsForValue().set("2a","b");
		redisTemplate.opsForValue().set("3a","b");
		redisTemplate.opsForValue().set("4a","b");
		redisTemplate.opsForValue().set("5a","b");
		redisTemplate.opsForValue().set("6a","b");
		redisTemplate.opsForValue().set("7a","b");
		redisTemplate.opsForValue().set("8a","b");
		redisTemplate.opsForValue().set("9a","b");
		redisTemplate.opsForValue().set("10a","b");
		redisTemplate.opsForValue().set("11a","b");
		redisTemplate.opsForValue().set("12a","b");
		redisTemplate.opsForValue().set("13a","b");
		redisTemplate.opsForValue().set("14a","b");
		redisTemplate.opsForValue().set("15a","b");
		return "success";
	}

}
