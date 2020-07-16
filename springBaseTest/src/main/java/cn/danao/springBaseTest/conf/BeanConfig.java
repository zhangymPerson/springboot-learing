package cn.danao.springBaseTest.conf;

import cn.danao.springBaseTest.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * date 2020/7/16 17:10 <br/>
 * description class <br/>
 * bean注入配置
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Configuration
@Slf4j
public class BeanConfig {

    /**
     * {@link Bean} 注解的对象
     * 注入到spring 容器中
     *
     * @return
     */
    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setName("conf create");
        log.info("config 中创建");
        return person;
    }

}
