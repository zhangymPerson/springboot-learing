# Mongo 整合 springboot

- [github 地址-spring-data-mongodb](https://github.com/spring-projects/spring-data-mongodb)

- pom.xml

  ```xml
  <!--添加mongo 相关的maven依赖-->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-mongodb</artifactId>
  </dependency>

  ```

- mongo 操作分两种

  编写 bean 对象 @Document 注解在类上 对应 collection 对象

  @Id 对应 \_id 字段

  @Field(value = "name") name 对应的是集合中的摸一个字段

  一种是编写接口 cn.danao.dao.UserTwoDao 继承 MongoRepository<Bean,String> 类

  一种是自定义接口 cn.danao.dao.UserDao 然后实现其中的方法 cn.danao.dao.imp.UserDaoImp
  主要使用 org.springframework.data.mongodb.core.MongoTemplate 这个对象对 bean 对象进行操作

- springboot 的测试

  cn.danao.controller.SpringBootBaseTest 类为 springboot 基准测试基类

## 两种操作 mongo 数据库的方式

### 自定义 dao 接口并实现

如：`cn.danao.dao.UserDao` 类 需要自定义实现 `cn.danao.dao.imp.UserDaoImp`，使用 `mongoTemplate` 对象注入，并操作 mongo 库

### 继承 MongoRepository<> 接口

如：`cn.danao.dao.UserTwoDao` 不需要自己实现 里面有常用的方法实现

可自己增加自定义的查询，需要按照一定的规则，可参考此类的实现
