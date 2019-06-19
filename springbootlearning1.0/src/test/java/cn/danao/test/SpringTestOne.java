package cn.danao.test;

import cn.danao.controller.base.SpringBootBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author danao
 * @version 1.0
 * @classname Test
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/4 16:21
 * @since 1.0
 */
@Slf4j
public class SpringTestOne extends SpringBootBaseTest {

    @Test
    public void test(){
        String testMsg = "测试类1的测试内容";
        log.info("{}",testMsg);
    }

}
