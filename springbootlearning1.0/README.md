# springboot项目使用


- springboot 启动过程分析


- springboot中的注解

| 注解 |说明|    
|-|-|    
|    @SpringBootApplication |    是spring boot的核心注解：包含了@ComponentScan、@Configuration和@EnableAutoConfiguration注解。其中@ComponentScan让spring Boot扫描到Configuration类并把它加入到程序上下文，@EnableAutoConfiguration让spring boot根据类路径中的jar包依赖为当前项目进行自动配置。
|    @Configuration|     等同于spring的XML配置文件；使用Java代码可以检查类型安全。
|    @EnableAutoConfiguration |    自动配置。
|    @ComponentScan |    组件扫描，可自动发现和装配一些Bean。
|    @Component |     泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。一般公共的方法会用上这个注解
|    @RestController|    注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。
|    @Autowired |    自动导入，把配置好的Bean拿来用，完成属性、方法的组装，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。当加上（required=false）时，就算找不到bean也不报错。
|    @PathVariable|    获取参数。
|    @JsonBackReference|    解决嵌套外链问题。
|    @RepositoryRestResourcepublic|    配合spring-boot-starter-data-rest使用。
|    @Profiles Spring Profiles|    提供了一种隔离应用程序配置的方式，并让这些配置只能在特定的环境下生效。任何@Component或@Configuration都能被|    @Profile|    标记，从而限制加载它的时机。
|    @value |    注解来读取application.properties里面的配置
|    @Inject|    等价于默认的@Autowired，只是没有required属性；
|    @Bean|    相当于XML中的,放在方法的上面，而不是类，意思是产生一个bean,并交给spring管理。
|    @RequestMapping|    提供路由信息，负责URL到Controller中的具体函数的映射。
|    @Configuration|    相当于传统的xml配置文件，如果有些第三方库需要用到xml文件，建议仍然通过@Configuration类作为项目的配置主类——可以使用@ImportResource|    注解加载xml配置文件。
|    @Import|    用来导入其他配置类。
|    @ImportResource|    用来加载xml配置文件。
|    @Service|    一般用于修饰service层的组件
|    @Repository|    使用@Repository注解可以确保DAO或者repositories提供异常转译，这个注解修饰的DAO或者repositories类会被ComponetScan发现并配置，同时也不需要为它们提供XML配置项。


- 拦截器 

    编写拦截器代码 实现HandlerInterceptor 接口
    
    配置拦截器使其生效
