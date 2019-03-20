package cn.danao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhang
 * @version 1.0
 * @classname RedisApplication
 * @descriptionclass
 * 1.启动类
 * 2.****************
 * @createdate 2019/3/20
 * @since 1.0
 */
@SpringBootApplication
@Configuration
public class RedisApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class);
	}
}
