# kotlin整合springboot代码

- springboot构建网站

   https://start.spring.io/ 

- 创建项目框架

    
- 项目打包命令

    有 `kotlin` 的代码 需要执行如下 `maven` 命令
    
    `mvn clean kotlin:compile package -D'maven.test.skip=true'`
    
    项目中不能有多个kotlin main()方法/函数，否则报错
    