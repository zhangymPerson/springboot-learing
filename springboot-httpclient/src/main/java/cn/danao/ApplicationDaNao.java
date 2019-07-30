package cn.danao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ApplicationDaNao {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDaNao.class);
        String url = "http://127.0.0.1:8080/danao/swagger-ui.html";
        System.out.println("访问地址:" + url);
    }
}
