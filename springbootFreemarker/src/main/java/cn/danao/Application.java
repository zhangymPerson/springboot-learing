package cn.danao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author danao
 * @version 1.0
 * @classname Application
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/8/27 18:41
 * @since 1.0
 */
@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        String url = "http://127.0.0.1:8885/danao/start/success";
        //log.info("项目访问地址: {}",url);
    }
}
