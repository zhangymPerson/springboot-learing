问题记录
---
记录一些使用问题

- flyway 的使用

  mysql 现在通过插件支持

  ```xml
  <dependency>
      <groupId>org.flywaydb</groupId>
      <artifactId>flyway-mysql</artifactId>
  </dependency>
  ```
  
  迁移目录在 application.yml 中配置
  
  迁移脚本的命名规则

  `V<VErsion>__<Description>.sql`

  举例:
  
  `V1.0.0__create_user.sql`
  
  `V1.0.1__insert_user.sql`
  
  `V1.0.2__update_user.sql`
  
  **注意** 两个下划线

 