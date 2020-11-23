# springboot 项目整合 druid 和 mysql 基本框架

- 测试表 sql

  ```sql
  -- 建表语句
  CREATE TABLE `user` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
  -- 插入测试数据
  INSERT INTO healthdata.`user` (id,name,age) VALUES
      (1,'张三',23),
      (2,'李四',23),
      (3,'测试',23),
      (4,'王五',23),
      (5,'马六',23),
      (6,'zhangsan',23),
      (7,'zhangsan',23),
      (8,'zhangsan',23),
      (9,'zhangsan',23);
  ```

- 整合 mybaties

- 整合 druid

  前端访问页面地址:http://127.0.0.1:8080/druid/login.html

  username/password = admin

- 返回结果的包装

  cn.danao.common.result.Result

### mybatis 工具

- idea 下载插件 Free Mybatis plugin

- mybatis-generator-maven-plugin

  使用方法 pom.xml 添加插件

  ```xml
  <!-- mybatis generator 自动生成代码插件 -->
  <plugin>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-maven-plugin</artifactId>
      <version>1.3.2</version>
      <configuration>
          <!--配置文件的位置-->
          <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>
          <overwrite>true</overwrite>
          <verbose>true</verbose>
      </configuration>
  </plugin>
  ```

  在 resource 目录下 创建出配置文件 : generatorConfig.xml

  配置 demo 如下

  **注意:以下 xml 中\<context\>标签中的内容前后顺序不能改,否则不能正确执行**

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE generatorConfiguration
          PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
          "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
  <generatorConfiguration>
      <!-- 数据库驱动:选择你的本地硬盘上面的数据库驱动包 注意mysql 5.0和8.0版本的jar区别 和 Driver的区别-->
      <classPathEntry
              location="D:\apache-maven-3.6.1\repository\mysql\mysql-connector-java\8.0.13\mysql-connector-java-8.0.13.jar"/>
      <context id="DB2Tables" targetRuntime="MyBatis3">
          <commentGenerator>
              <property name="suppressDate" value="true"/>
              <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
              <property name="suppressAllComments" value="true"/>
          </commentGenerator>
          <!--数据库链接URL，用户名、密码 -->
          <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver" connectionURL="jdbc:mysql://127.0.0.1/dbname"
                          userId="root"
                          password="123456">
          </jdbcConnection>
          <javaTypeResolver>
              <property name="forceBigDecimals" value="false"/>
          </javaTypeResolver>

          <!-- 生成模型的包名和位置-->
          <javaModelGenerator targetPackage="cn.danao.generator.model" targetProject="src/main/java">
              <property name="enableSubPackages" value="true"/>
              <property name="trimStrings" value="true"/>
          </javaModelGenerator>


          <!-- 生成映射文件的包名和位置-->
          <sqlMapGenerator targetPackage="main.resources.mapping" targetProject="src">
              <!-- enableSubPackages:是否让schema作为包的后缀 -->
              <property name="enableSubPackages" value="false"/>
          </sqlMapGenerator>

          <!-- 生成DAO的包名和位置-->
          <javaClientGenerator type="XMLMAPPER" targetPackage="cn.danao.generator.dao" targetProject="src/main/java">
              <property name="enableSubPackages" value="true"/>
          </javaClientGenerator>

          <!-- 要生成的表 tableName是数据库中的表名或视图名 domainObjectName是实体类名-->
          <table tableName="user"
                 domainObjectName="User"
                 enableCountByExample="false"
                 enableUpdateByExample="false"
                 enableDeleteByExample="false"
                 enableSelectByExample="false"
                 selectByExampleQueryId="false">
          </table>
      </context>
  </generatorConfiguration>
  ```

- bug 解决 dtd 路径飘红 `http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd`

  idea 设置: settings ->搜索 dtds 添加 url

- idea 中点击 maven 中插件 执行 mybatis-generator-maven-plugin 即可生成 对应的 model / dao /mapper 文件

- 项目配置 mapper 文件夹位置

  ```properties
  # 指定 mapper.xml文件夹
  mybatis.mapper-locations=classpath:mapping/**.xml
  ```
