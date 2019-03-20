package cn.danao.test;

import org.springframework.data.redis.connection.jedis.JedisConnection;
import redis.clients.jedis.Jedis;

/**
 * @author zhang
 * @version 1.0
 * @classname Test
 * @descriptionclass
 * 1.测试redis连接方式
 * @createdate 2019/3/20
 * @since 1.0
 */
public class Test {



	public static final Jedis jedis = new Jedis("127.0.0.1",6379);

	public static void main(String[] args) {
		System.out.println("Hello Word");
		jedis.auth("123456...");
		jedis.set("a","b");
	}
}
