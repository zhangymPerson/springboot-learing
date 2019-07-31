package cn.danao;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author danao
 * @version 1.0
 * @classname SpingBasicTest
 * @descriptionclass 1.测试类
 * 2.其他说明
 * @createdate 2019/7/31 10:20
 * @since 1.0
 */
@RunWith(SpringRunner.class)
//@RunWith(JUnit4.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class SpringBasicTest {
    @Before
    public void setUp() throws Exception {
        String startMsg = "测试开始信息";
        log.info("{}", startMsg);
    }

    @After
    public void tearDown() throws Exception {
        String endMsg = "测试结束信息";
        log.info("{}", endMsg);

    }
}