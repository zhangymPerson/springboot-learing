package cn.danao.springBaseTest;

import cn.danao.springBaseTest.bean.Person;
import cn.danao.springBaseTest.conf.BeanConfig;
import cn.danao.springBaseTest.server.WorkServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * springboot 不包含网络服务的测试
 */
@SpringBootApplication
@Slf4j
public class SpringBaseTestApplication {


    /**
     * spring 注入的静态变量的方式
     * 添加包含静态变量的构造函数 注：需要配合 @Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常
     *
     * @param workServer
     */
    public SpringBaseTestApplication(WorkServer workServer) {
        log.info("初始化对象，构造出的workServer对象是[{}]", workServer);
        workServerImpl = workServer;
    }

    @Autowired
    private static WorkServer workServerImpl;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBaseTestApplication.class, args);
        log.info("spring 容器对象 [{}]", context);
        getBeanTest(context);
        //测试服务
        getServiceTest(context);
        getServiceStaticTest();
    }


    /**
     * 测试静态注入
     */
    public static void getServiceStaticTest() {
        log.info("通过静态构造函数赋值的workServer对象是[{}]", workServerImpl);
        //静态注入测试
        Map<String, Object> map = new HashMap<>();
        map.put("key", "test");
        Map<String, Object> result = workServerImpl.doWork(map);
        log.info("测试静态服务运行返回的内容是{}", result);
    }

    /**
     * 测试服务运行
     *
     * @param context
     */
    public static void getServiceTest(ConfigurableApplicationContext context) {
        //@Service 注解如果不添加配置 则默认注册的bean 位 类名 + 首字母小写
        WorkServer workServer = (WorkServer) context.getBean("workServerImpl");
        WorkServer otherWorkServer = (WorkServer) context.getBean("otherWorkServerImpl");
        log.info("通过getBean获取到的workServer对象分别是[{}],[{}]", workServer, otherWorkServer);
        Map<String, Object> map = new HashMap<>();
        map.put("key", "test");
        Map<String, Object> result = workServer.doWork(map);
        Map<String, Object> otherResult = otherWorkServer.doWork(map);
        log.info("测试服务运行返回的内容是\n{}\n{}", result, otherResult);
    }

    /**
     * 测试获取spring 容器管理的 注册好的 bean 对象
     *
     * @param context 容器
     */
    public static void getBeanTest(ConfigurableApplicationContext context) {
        // exception  No bean named 'getUser' available
        // Object getUser = context.getBean("getUser");
        Object person = context.getBean("getPerson");
        Object personApp = context.getBean("getPersonApp");
        Object personBean = context.getBean("person");
        log.info("config类 {} app类 {} 指定bean名称 {}", person, personApp, personBean);
    }


    /**
     * 如果无 注解 @Bean 此方法不会注册bean
     * 使用@Bean 注解表明myBean需要交给Spring进行管理
     * 未指定bean 的名称，默认采用的是 "方法名" + "首字母小写"的配置方式
     * <p>
     * 如果方法名和 {@link BeanConfig} 中注册的bean一致则报错
     * Bean注解
     *
     * @return
     */
    @Bean
    public Person getPersonApp() {
        Person person = new Person();
        person.setName("app create");
        log.info("主类中创建对象");
        return person;
    }

    /**
     * 指定bean 的名称
     * 默认是方法名 首字母小写
     *
     * @return
     */
    @Bean(name = "person")
    public Person getPerson() {
        Person person = new Person();
        person.setName("bean name is person");
        return person;
    }

}
