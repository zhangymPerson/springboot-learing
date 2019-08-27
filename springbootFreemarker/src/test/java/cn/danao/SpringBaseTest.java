package cn.danao;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author danao
 * @version 1.0
 * @classname SpringBaseTest
 * @descriptionclass
 * 1.测试基类
 * 2.其他说明
 * @createdate 2019/8/27 18:43
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class SpringBaseTest {
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
