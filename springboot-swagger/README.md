# spring boot 整合swagger


- 引入jar包

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${version.swagger}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${version.swagger}</version>
        </dependency>

- 添加注解

    入口类 ： @EnableSwagger2
    
    Controller ：@Api("测试")
    
    请求方法：@ApiOperation("测试接口")

- 请求

        #请求页面
        http://localhost:port/swagger-ui.html
        