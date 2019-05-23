### springboot项目热部署的开启 修改代码不需要重启项目

- pom.xml文件添加一下信息

    ```xml
    <!--springboot的热部署  还必须添加maven的springboot的插件才可以-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <!-- 这个需要为 true 热部署才有效 -->
        <optional>true</optional>
    </dependency>

    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
            </configuration>
        </plugin>
    </plugins>
    ```

- application.properties

    ```conf
    #热部署相关的配置说明
    #热部署生效
    spring.devtools.restart.enabled: true
    #设置重启的目录
    #spring.devtools.restart.additional-paths: src/main/java
    #classpath目录下的WEB-INF文件夹内容修改不重启
    #spring.devtools.restart.exclude: WEB-INF/**
    ```

- IDEA需要修改的配置
    
     当我们修改了Java类后，IDEA默认是不自动编译的，而spring-boot-devtools又是监测classpath下的文件发生变化才会重启应用，所以需要设置IDEA的自动编译：

    - File-Settings-Compiler-Build Project automatically

    - ctrl + shift + alt + /,选择Registry,勾上 Compiler autoMake allow when app running