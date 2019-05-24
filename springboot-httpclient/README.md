# spring boot 请求其他网站的接口

- 读取配置文件

       自定义配置文件
       
       自定义配置文件对应的类 加注解 
       
        @PropertySource("classpath:url-info.properties")
        @Component
        
       在Controller 中添加注解@Autowired注解将配置类引入
      
      
- springboot 请求其他接口

    我们可以使用JDK原生的URLConnection、Apache的Http Client、Netty的异步HTTP Client, Spring的RestTemplate。但是，用起来最方便、最优雅的还是要属Feign了。