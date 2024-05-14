# spring boot 请求其他网站的接口

- 读取配置文件

  自定义配置文件

  自定义配置文件对应的类 加注解

  ```java
  @PropertySource("classpath:url-info.properties")
  @Component
  ```

  在 Controller 中添加注解@Autowired 注解将配置类引入

- springboot 请求其他接口

  我们可以使用 JDK 原生的 URLConnection、Apache 的 Http Client、Netty 的异步 HTTP Client, Spring 的 RestTemplate。但是，用起来最方便、最优雅的还是要属 Feign 了。
