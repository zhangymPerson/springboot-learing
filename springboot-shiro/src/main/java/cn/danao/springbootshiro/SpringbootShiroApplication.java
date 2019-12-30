package cn.danao.springbootshiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置springboot注解生效的包 多个包用,隔开 有些包需要使用，但是不在启动包的子包中时使用
 */
@SpringBootApplication(scanBasePackages = {"cn.danao"})
public class SpringbootShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroApplication.class, args);
    }

}
