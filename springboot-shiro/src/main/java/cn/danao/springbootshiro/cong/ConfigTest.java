package cn.danao.springbootshiro.cong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author danao
 * @version 1.0
 * @classname ConfigTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/10/14 17:05
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = {"cn.daonao.controller"})
@Slf4j
public class ConfigTest {

    public void test(){
        log.info("ceshi");
    }
}
