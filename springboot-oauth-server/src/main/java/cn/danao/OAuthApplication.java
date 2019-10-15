package cn.danao;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

/**
 * @author danao
 * @version 1.0
 * @classname OAuthApplication
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/10/15 15:09
 * @since 1.0
 */
@EnableGlobalAuthentication
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class OAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class, args);
    }
}
