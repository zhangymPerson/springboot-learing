package cn.danao.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author danao
 * @version 1.0
 * @classname PropertiesConfig
 * @descriptionclass
 *
 * 1.第二种读取配置文件 properties文件方式
 * @createdate 2019/6/3 16:58
 * @since 1.0
 */
//@Component
@Configuration()
@PropertySource("classpath:pro.properties")
public class PropertiesConfig {

    @Value("${pro.test}")
    public String proTest;

}
