package cn.danao.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author danao
 * @version 1.0
 * @classname BaseSpringTestController
 * @descriptionclass
 * 1.spring单元测试基类
 * @createdate 2019/6/19 9:59
 * @since 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
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