- 使用 Spring Security

- maven

  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
  </dependency>
  ```

- 开启方式

  在 springboot 启动类上添加 @EnableGlobalAuthentication 注解

- 开启后访问需要输入用户名和密码

  用户名 默认是 user

  密码在日志中 Using generated security password: 1456c136-60ac-4636-a7fb-388754451f2b 随机的

  密码可配置 在 application.properties 中

  ```properties
  # security 用户名
  spring.security.user.name=admin
  spring.security.user.password=admin
  ```
