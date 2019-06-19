package cn.danao.controller.base;

import cn.danao.test.SpringTest;
import cn.danao.test.SpringTestOne;
import cn.danao.test.SpringTestTwo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author danao
 * @version 1.0
 * @classname TestController
 * @descriptionclass
 *
 * 1.springboot的测试基类
 * 2.主要用于springboot的测试
 *
 * Suite 是一个测试框架
 *
 * 编写好其他的测试内容后，可以集中在一个类里面进行管理 运行这一个类
 * 可以同时测试 @Suite.SuiteClasses 注解里的其他类中的测试方法和测试相关的数据
 *
 *
 * @since 1.1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({SpringTest.class, SpringTestOne.class, SpringTestTwo.class})
@SpringBootTest
@Slf4j
public class SpringBootBaseTestSuite {

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
