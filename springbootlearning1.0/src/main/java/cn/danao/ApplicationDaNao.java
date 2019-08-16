package cn.danao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 添加自定义bean配置需要使用 ImportResource 注解
 */
@ImportResource(locations = {"classpath:applicationContext.xml"})
@SpringBootApplication
@Slf4j
public class ApplicationDaNao {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDaNao.class);
        String url = "http://127.0.0.1:8885/danao/start/success";
        //log.info("项目访问地址: {}",url);
    }
}
