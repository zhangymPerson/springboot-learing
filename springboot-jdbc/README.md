- springboot 项目基本框架

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
