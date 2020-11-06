package cn.danao.test;

import cn.danao.bean.UserInfo;
import cn.danao.controller.base.SpringBootBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
        UserInfo userInfo = new UserInfo();
        if (userInfo!=null) {

        }
        List<Object> a = Arrays.asList("a");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (Map.Entry<Object, Object> entry : objectObjectHashMap.entrySet()) {
            Object k = entry.getKey();
            Object v = entry.getValue();
            System.out.println(k);
        }
        for (Object o : a) {

        }
        for (int i = 0; i < a.size(); i++) {

        }
        for (Object aa : a) {
            System.out.println(a);
        }
    }

}
