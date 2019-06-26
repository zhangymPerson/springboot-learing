package cn.danao.test.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author danao
 * @version 1.0
 * @classname SpringTest
 * @descriptionclass
 * 1.spring测试
 * 2.其他说明
 * @createdate 2019/6/26 18:00
 * @since 1.0
 */
@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class SpringTest {
    public static void main(String[] args) {
        log.info("测试");
        System.out.println("测试");
    }
}
