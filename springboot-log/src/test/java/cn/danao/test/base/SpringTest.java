package cn.danao.test.base;

import cn.danao.bean.strinfo.A;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname SpringTest
 * @descriptionclass 1.spring测试
 * 2.其他说明
 * @createdate 2019/6/26 18:00
 * @since 1.0
 */
@SpringBootTest()
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class SpringTest {

    public static void main(String[] args) {
        // exec执行方式，无需传递Map格式
        String age = "18";
        System.out.println(AviatorEvaluator.exec("'His age is '+ age +'!'", age));
        // Compile the script into a Expression instance.
        Expression exp = null;
        try {
            //执行文件
            String path = "D:\\person\\github\\springboot-learing\\springboot-log\\src\\test\\resources\\example\\helloword.av";
            exp = AviatorEvaluator.getInstance().compileScript(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Run the exprssion.
        exp.execute();
        File test = new File("test.av");
        try {
            OutputStream outputStream = new FileOutputStream(test);
            try {
                outputStream.write("测试".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        A a = new A(1);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", a);
        String exeStr = "'A = ' + a.id + a.name + a.stringList";

        System.out.println("a");
        String s = (String) AviatorEvaluator.execute(exeStr, map);
        System.out.println(s);

        // execute执行方式，需传递Map格式
        map.put("age", "18");
        System.out.println(AviatorEvaluator.execute("'His age is '+ age +'!'",
                map));

    }
}
