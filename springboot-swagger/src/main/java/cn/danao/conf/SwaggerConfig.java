package cn.danao.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * create date 2019/10/18 11:25
 * description class
 * 1.swagger 的相关配置类
 * 2.@Profile 指定swagger激活使用的环境
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Configuration
@Profile({"dev", "test", "prod"})
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 注意 这个配置必须是去掉 https:// 或 http:// 以后  项目路径之前的地址
     * eg: https://www.baidu.com/url/danao/test
     * 则只配置 www.baidu.com/url
     * /danao属于本项目的路由
     * 如果不配置  则使用swagger时，不走域名和nginx 走的是真是的服务器地址
     */
    @Value("${server_host}")
    String serverHost;

    /**
     * 自定义是否过滤swagger
     */
    @Value("${swagger.is.enable}")
    private boolean isSwagger;


    /**
     * Api配置
     *
     * @return Docket对象
     */
    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //配置线上服务 有域名时测试的地址
                //.host(serverHost)
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


    /**
     * 构建 api文档的详细信息函数
     *
     * @return ApiInfo对象
     */
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
