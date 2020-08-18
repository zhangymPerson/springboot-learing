package cn.danao.springBaseTest.bean;

import cn.danao.springBaseTest.SpringBaseTestApplicationTests;
import cn.danao.springBaseTest.bean.mock.Args;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * date 2020/8/18 9:50 <br/>
 * description class <br/>
 * mock测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class MockTest extends SpringBaseTestApplicationTests {

    @Test
    public void test() {
        //模拟创建一个List对象
        List<Integer> mock = mock(List.class);
        //调用mock对象的方法
        mock.add(1);
        mock.clear();
        //验证方法是否执行
        Mockito.verify(mock).add(1);
        Mockito.verify(mock).contains("32");
    }

    @Test
    public void test1() {
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        Mockito.when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next() + "" + iterator.next();
        //验证结果
        assertEquals("hello world world", result);
    }

    /**
     * 模拟抛出异常
     */
    @SneakyThrows
    @Test
    public void test2() {
        OutputStream mock = Mockito.mock(OutputStream.class);
        //预设当流关闭时抛出异常
        Mockito.doThrow(new IOException()).when(mock).close();
        mock.close();
    }

    @Test
    @DisplayName("Junit5 built-in Assertions.assertThrows and Assertions.assertAll")
    @Tag("exception-testing")
    public void verifiesTypeAndMessage() {
        Throwable throwable = assertThrows(Exception.class, () -> {
            throw new Exception("My custom runtime exception");
        });

        assertAll(
                () -> assertEquals("My custom runtime exception", throwable.getMessage()),
                () -> assertNull(throwable.getCause())
        );
    }


    @Test
    public void test3() {
        Args args = Mockito.mock(Args.class);
        //预设根据不同的参数返回不同的结果
        Mockito.when(args.getSex(1)).thenReturn("男");
        Mockito.when(args.getSex(2)).thenReturn("女");
        assertEquals("男", args.getSex(1));
        assertEquals("女", args.getSex(2));
        //对于没有预设的情况会返回默认值
        assertEquals(null, args.getSex(0));
        log.info("args={}", args);
    }
}
