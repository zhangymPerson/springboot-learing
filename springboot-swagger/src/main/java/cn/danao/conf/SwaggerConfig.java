package cn.danao.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.Doc;

/**
 * @author danao
 * @version 1.0
 * @classname SwaggerConfig
 * @descriptionclass 1.swagger 的相关配置类
 * 2.其他说明
 * @createdate 2019/10/18 11:25
 * @since 1.0
 */
@Slf4j
@Configuration
@Profile({"dev","test"})
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 自定义是否过滤swagger
     */
    @Value("${swagger.is.enable}")
    private boolean isSwagger;

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    /*@Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                //过滤所有路径
                .paths(PathSelectors.none())
                .build();
        log.info("isSwagger = {}", isSwagger);
        if (isSwagger) {
            log.info("true");
            docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())//调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                    .select()
                    //控制暴露出去的路径下的实例
                    //如果某个接口不想暴露,可以使用以下注解
                    //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                    .apis(RequestHandlerSelectors.basePackage("cn.danao.controller"))
                    .paths(PathSelectors.any())
                    .build();
        }
        return docket;
    }*/


    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .apiInfo(apiInfo())
                //.enable(isSwagger)
                .select()
                //控制暴露出去的路径下的实例
                //如果某个接口不想暴露,可以使用以下注解
                //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("cn.danao.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot Swagger2 构建RESTful API")
                //条款地址
                .termsOfServiceUrl("https://github.com/zhangymPerson")
                //相关信息
                .contact(new Contact("danao", "https://github.com/zhangymPerson", "zhangyanmingjiayou@163.com"))
                .version("1.0")
                //描述
                .description("项目相关的API说明")
                .build();
    }
}
