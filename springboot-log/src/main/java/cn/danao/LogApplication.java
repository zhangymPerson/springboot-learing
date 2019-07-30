package cn.danao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang
 * @version 1.0
 * @classname LogApplication
 * @descriptionclass
 * 1.启动类主类
 * 2.****************
 * @createdate 2019/3/20
 * @since 1.0
 */
@SpringBootApplication
@Slf4j
public class LogApplication {
	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class);
		String url = "http://127.0.0.1:8080/danao/start/success";
		log.info("项目访问地址: {}",url);
	}
}
