package cn.danao.springBaseTest;

import cn.danao.springBaseTest.bean.Person;
import cn.danao.springBaseTest.conf.BeanConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * springboot 不包含网络服务的测试
 */
@SpringBootApplication
@Slf4j
public class SpringBaseTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBaseTestApplication.class, args);
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
