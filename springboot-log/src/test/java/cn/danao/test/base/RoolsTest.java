package cn.danao.test.base;

import cn.danao.bean.strinfo.A;
import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * date 2020/6/5 14:23 <br/>
 * description class <br/>
 * mvel 测试代码
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class RoolsTest {

    public static void main(String[] args) {
        String myExpression = "value1 + value2";
        Integer result = calculate(myExpression);
        System.out.println("The result of expression [" + myExpression + "] is: " + result);

        myExpression = "value1 + (value2 * 2)";
        result = calculate(myExpression);
        System.out.println("The result of expression [" + myExpression + "] is: " + result);

        myExpression = "value1 * value2";
        result = calculate(myExpression);
        System.out.println("The result of expression [" + myExpression + "] is: " + result);
    }

    public static Integer calculate(String expression) {
        Map<String, Integer> values = new LinkedHashMap<String, Integer>();
        values.put("value1", 2);
        values.put("value2", 3);
        final Serializable str = MVEL.compileExpression(expression);
        return (Integer) MVEL.executeExpression(str, values);
    }


    @Test
    public void test() {
        String test = "a.id + a.name + a.stringList + a.b.id + a.b.name";
        Map<String, Object> map = new HashMap<>();
        map.put("a", new A(3));
        calculate(test, map);
    }


    public void calculate(String expression, Map<String, Object> map) {
        final Serializable str = MVEL.compileExpression(expression);
        Object o = MVEL.executeExpression(str, map);
        System.out.println(o);
    }
}
