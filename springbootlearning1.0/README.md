# springboot 项目使用

- springboot 启动过程分析

- springboot 中的注解

  | 注解                          | 说明                                                                                                                                                                                                                                                                        |
  | ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------- | ---------------------------- |
  | @SpringBootApplication        | 是 spring boot 的核心注解：包含了@ComponentScan、@Configuration 和@EnableAutoConfiguration 注解。其中@ComponentScan 让 spring Boot 扫描到 Configuration 类并把它加入到程序上下文，@EnableAutoConfiguration 让 spring boot 根据类路径中的 jar 包依赖为当前项目进行自动配置。 |
  | @Configuration                | 等同于 spring 的 XML 配置文件；使用 Java 代码可以检查类型安全。                                                                                                                                                                                                             |
  | @EnableAutoConfiguration      | 自动配置。                                                                                                                                                                                                                                                                  |
  | @ComponentScan                | 组件扫描，可自动发现和装配一些 Bean。                                                                                                                                                                                                                                       |
  | @Component                    | 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。一般公共的方法会用上这个注解                                                                                                                                                                                  |
  | @RestController               | 注解是@Controller 和@ResponseBody 的合集,表示这是个控制器 bean,并且是将函数的返回值直 接填入 HTTP 响应体中,是 REST 风格的控制器。                                                                                                                                           |
  | @Autowired                    | 自动导入，把配置好的 Bean 拿来用，完成属性、方法的组装，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。当加上（required=false）时，就算找不到 bean 也不报错。                                                                                              |
  | @PathVariable                 | 获取参数。                                                                                                                                                                                                                                                                  |
  | @JsonBackReference            | 解决嵌套外链问题。                                                                                                                                                                                                                                                          |
  | @RepositoryRestResourcepublic | 配合 spring-boot-starter-data-rest 使用。                                                                                                                                                                                                                                   |
  | @Profiles Spring Profiles     | 提供了一种隔离应用程序配置的方式，并让这些配置只能在特定的环境下生效。任何@Component 或@Configuration 都能被                                                                                                                                                                | @Profile                | 标记，从而限制加载它的时机。 |
  | @value                        | 注解来读取 application.properties 里面的配置                                                                                                                                                                                                                                |
  | @Inject                       | 等价于默认的@Autowired，只是没有 required 属性；                                                                                                                                                                                                                            |
  | @Bean                         | 相当于 XML 中的,放在方法的上面，而不是类，意思是产生一个 bean,并交给 spring 管理。                                                                                                                                                                                          |
  | @RequestMapping               | 提供路由信息，负责 URL 到 Controller 中的具体函数的映射。                                                                                                                                                                                                                   |
  | @Configuration                | 相当于传统的 xml 配置文件，如果有些第三方库需要用到 xml 文件，建议仍然通过@Configuration 类作为项目的配置主类——可以使用@ImportResource                                                                                                                                      | 注解加载 xml 配置文件。 |
  | @Import                       | 用来导入其他配置类。                                                                                                                                                                                                                                                        |
  | @ImportResource               | **用来加载 xml 配置文件。**                                                                                                                                                                                                                                                 |
  | @Service                      | 一般用于修饰 service 层的组件                                                                                                                                                                                                                                               |
  | @Repository                   | 使用@Repository 注解可以确保 DAO 或者 repositories 提供异常转译，这个注解修饰的 DAO 或者 repositories 类会被 ComponetScan 发现并配置，同时也不需要为它们提供 XML 配置项。                                                                                                   |

- 拦截器

  编写拦截器代码 实现 HandlerInterceptor 接口

  配置拦截器使其生效

- 读取自定义的配置文件

  自定义一个实现类

  cn.danao.conf.PropertyPlaceholder

  编写配置文件

  classpath:applicationContext.xml

  在启动类中添加相关的注解

  @ImportResource(locations = {"classpath:applicationContext.xml"})

- 另一种配置文件可以使用注解

  参考这个类 cn.danao.conf.PropertiesConfig

  注解

  @Configuration()

  @PropertySource("classpath:pro.properties")

  **@PropertySource 这个注解可以指定具体的属性配置文件，优先级比较低。**

  @Value("${key}")

  **注意:这种方式和上面的直接工具类读取的方式有冲突**

- aop 切面
- 自定义载入内容

  在项目的 resource 目录中添加 名为 “banner.txt” 的文本文件 即可自定义 springboot 的启动文件

  该文件中的内容可以读取配置显示 如 Port: ${server.port} 会读取配置文件中的内容或者监听器中 set 进去的内容

- springboot 项目创建监听器

  编写类 实现 org.springframework.boot.SpringApplicationRunListener 接口

  **编写实现类必须要创建构造方法 无构造方法则无法正确加载该监听器**

  ```java
     public StartingSpringApplicationRunListener(SpringApplication application, String... args) {
          log.debug("监听器正在初始化...");
      }
  ```

  在配置文件夹 resource 目录下 添加新文件夹 META-INF 创建文件 spring.factories

  配置自定义类

  ```properties
  org.springframework.boot.SpringApplicationRunListener=\
  cn.danao.listener.StartingSpringApplicationRunListener
  ```

- springboot 中的 mock 测试

  引入包 **spring-boot-starter-test**

  mock 的使用方式见包**cn.danao.controller.mock**下的相关测试类
