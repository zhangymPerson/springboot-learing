# Mongo整合springboot

- [github地址-spring-data-mongodb](https://github.com/spring-projects/spring-data-mongodb)

- pom.xml 

    ```xml
    <!--添加mongo 相关的maven依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
    
    ```
    
- mongo 操作分两种

    编写bean对象 @Document 注解在类上 对应collection对象
    
    @Id 对应 _id 字段
    
     @Field(value = "name") name 对应的是集合中的摸一个字段

    一种是编写接口 cn.danao.dao.UserDaoTest 继承 MongoRepository<Bean,String> 类
    
    一种是自定义接口 cn.danao.dao.UserDao 然后实现其中的方法 cn.danao.dao.imp.UserDaoImp
    主要使用 org.springframework.data.mongodb.core.MongoTemplate 这个对象对bean对象进行操作
    
- springboot的测试

    cn.danao.controller.SpringBootBaseTest 类为springboot基准测试基类