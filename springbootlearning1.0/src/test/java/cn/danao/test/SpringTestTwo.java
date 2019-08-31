package cn.danao.test;

import cn.danao.controller.base.SpringBootBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Scanner;

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
public class SpringTestTwo extends SpringBootBaseTest {

    @Test
    public void test() {
        String testMsg = "测试类2的内容!";
        log.info("{}", testMsg);
    }

    @Test
    public void testScanner() {
        Scanner scanner = new Scanner(System.in);
        String arg = "";
        System.out.println("请输入：");
        if (scanner.hasNext()) {
            /**
             * 使用netLine 读到下一行为止 如果使用next 则读到 空格为止
             */
            arg = scanner.nextLine();
        }
        System.out.println("输入值为:" + arg);
    }
}
