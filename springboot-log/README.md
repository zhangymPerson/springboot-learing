# springboot 整合log日志文件

- 要配置logback-spring.xml，

    spring boot会默认加载此文件，为什么不配置logback.xml,
    
    因为logback.xml会先application.properties加载，
    
    而logback-spring.xml会后于application.properties加载，
    
    这样我们在application.properties文中设置日志文件名称和文件路径才能生效。
    
    
- 配置日志文件输出位置

        在 logback-spring.xml 配置文件中配置输出位置
        
        <!-- name的值是变量的名称，value的值时变量定义的值。通过定义的值会被插入到logger上下文中。定义变量后，可以使“${}”来使用变量。 -->
        <property name="logging.path" value="C:/Users/zhang/Desktop" />
        
        <!--配置从 application.properties 中读取日志文件位置 -->
        <springProperty scope="context" name="logging.path" source="logging.path"/>