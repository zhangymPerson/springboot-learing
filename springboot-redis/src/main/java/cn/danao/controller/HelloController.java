package cn.danao.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
		RedisTemplate<String,String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.opsForValue().set("a","b");
		return "success";
	}

}
