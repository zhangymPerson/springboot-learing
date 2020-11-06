# kotlin 整合 springboot 代码

- springboot 构建网站

  https://start.spring.io/

- 创建项目框架
- 项目打包命令

  有 `kotlin` 的代码 需要执行如下 `maven` 命令

  `mvn clean kotlin:compile package -D'maven.test.skip=true'`

  项目中不能有多个 kotlin main()方法/函数，否则报错

- kotlin 中 private 关键字的

  private 将⼀个声明标记为在当前类或⽂件中可⻅

- kotlin 中没有 Object 对象 可以使用 Any 对象替代 如果允许为空 则需要加?
