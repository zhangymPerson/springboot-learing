package cn.danao.test;

import cn.danao.annotation.LogNote;
import cn.danao.annotation.TestNote;
import cn.danao.test.base.SpringTest;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author danao
 * @version 1.0
 * @classname AnnotationTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/6/26 18:08
 * @since 1.0
 */
public class AnnotationTest extends SpringTest {

    @TestNote(test = "我猜你找不到我")
    public void testAnntation(){
        System.out.println("测试注解");
    }


    @Test
    public void test(){
        System.out.println("test");
        try {
            /**
             * 获取注解的方式是通过反射注解使用对象
             */
            Class cc = Class.forName("cn.danao.test.AnnotationTest");
            Method[] methods = cc.getMethods();
            for(Method method:methods){
                if(method.isAnnotationPresent(TestNote.class)){
                    TestNote testNote = method.getAnnotation(TestNote.class);
                    System.out.println(testNote.test());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
