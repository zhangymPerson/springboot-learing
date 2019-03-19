package cn.danao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang
 * @version 1.0
 * @classname Applicattion
 * @descriptionclass 1.****************
 * 2.****************
 * @createdate 2019/3/19
 * @since 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.danao.dao")
public class Applicattion {
	public static void main(String[] args) {
		SpringApplication.run(Applicattion.class);
	}
}
