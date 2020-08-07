# spring boot 整合 swagger

- 引入 jar 包

  ```xml
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
  ```

- 添加注解

  入口类 ： @EnableSwagger2

  Controller ：@Api("测试")

  请求方法：@ApiOperation("测试接口")

- 请求页面

  http://localhost:port/swagger-ui.html

* swagger 的常用注解

  @ApiOperation：用在方法上，说明方法的作用

        value: 表示接口名称
        notes: 表示接口详细描述

  @ApiImplicitParams：用在方法上包含一组参数说明

  @ApiImplicitParam：用在@ApiImplicitParams 注解中，指定一个请求参数的各个方面

  paramType：参数位置
  header 对应注解：@RequestHeader
  query 对应注解：@RequestParam
  path 对应注解: @PathVariable
  body 对应注解: @RequestBody
  name：参数名
  dataType：参数类型
  required：参数是否必须传
  value：参数的描述
  defaultValue：参数的默认值
  @ApiResponses：用于表示一组响应

  @ApiResponse：用在@ApiResponses 中，一般用于表达一个错误的响应信息

  code：状态码
  message：返回自定义信息
  response：抛出异常的类
  @ApiIgnore: 表示该接口函数不对 swagger2 开放展示

## swagger 配置类

### 类名

- cn.danao.conf.SwaggerConfig

### 关闭 swagger 的几种方式

- 第一种配置 (不同环境不同启动配置)

  Swagger 的 congif 类上声明@Profile({"dev", "test"}),发布到生产上使用 product 的 profile 时， swagger 是无效的。

  ```java
  @Configuration
  //只开启dev和test环境中的配置
  @Profile({"dev","test"})
  @EnableSwagger2
  public class SwaggerConfig {
    //配置代码略去
  }
  ```

- 第二种代码读取配置

  在配置文件中添加

  ```properties
  #是否激活 swagger true or false
  swagger.is.enable=true
  ```

  ```java

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
  ```

## swagger-bootstrap-ui 的 swagger 的美化版本的

> 前提: swagger 提前配置好的，可以请求的

- 添加 jar 包

  ```xml
  <dependency>
      <groupId>com.github.xiaoymin</groupId>
      <artifactId>knife4j-spring-boot-starter</artifactId>
      <version>2.0.0</version>
  </dependency>
  ```

- 请求地址

  swagger-bootstrap-ui 默认访问地址是：http://${host}:${port}/doc.html

# apidoc在项目中的使用

- apidoc使用

    [个人笔记网址](https://github.com/zhangymPerson/learning-notes/tree/master/programming-language/JavaScript/apidoc)
    
- 使用步骤

    1.创建apidoc的json配置文件 在项目名下，和 src 目录同一目录下
    
    2.在src/目录的代码中 按照apidoc规则定义好相关的注释
    
    3.在项目目录上执行 `apidoc -i src/ -o out/` 即可将apidoc生成的接口项目返回给前端