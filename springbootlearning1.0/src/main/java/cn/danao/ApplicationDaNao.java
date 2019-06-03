package cn.danao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 添加自定义bean配置需要使用 ImportResource 注解
 */
@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
public class ApplicationDaNao {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDaNao.class);
    }
}
