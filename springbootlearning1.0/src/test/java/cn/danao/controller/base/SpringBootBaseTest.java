package cn.danao.controller.base;

import cn.danao.test.SpringTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author danao
 * @version 1.0
 * @classname TestController
 * @descriptionclass
 *
 * 1.springboot的测试基类
 * 2.主要用于springboot的测试
 *
 * @RunWith就是一个运行器
 *
 * @RunWith(JUnit4.class)就是指用JUnit4来运行
 *
 * @RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
 *
 * @RunWith(Suite.class)的话就是一套测试集合
 *
 *
 * =================================================
 *
 * @ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
 *
 * 单个文件
 * @ContextConfiguration(Locations="classpath：applicationContext.xml")
 * @ContextConfiguration(classes = SimpleConfiguration.class)
 *
 * 多个文件时，可用
 * @ContextConfiguration(locations = { "classpath:spring1.xml", "classpath:spring2.xml" })
 *
 * @createdate 2019/6/4 16:23
 * @since 1.0
 */
//@RunWith(SpringRunner.class)
@RunWith(JUnit4.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootBaseTest {

    @Before
    public void setUp() throws Exception {
        String startMsg = "测试开始信息";
        log.info("{}",startMsg);
    }

    @After
    public void tearDown() throws Exception {
        String endMsg = "测试结束信息";
        log.info("{}",endMsg);
    }

}
