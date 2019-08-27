package cn.danao.test;

import cn.danao.SpringBaseTest;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname SpringTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/8/27 18:44
 * @since 1.0
 */
public class SpringTest extends SpringBaseTest {

    @Test
    public void test() throws Exception{
        System.out.println("测试");
        Map<String, String> map=new HashMap<String, String>();
        map.put("username", "lisi");
        String templateString="${username}/zhangsan";
        StringWriter result = new StringWriter();
        Template t = new Template("name1", new StringReader(templateString), new Configuration());
        t.process(map, result);
        System.out.println(result.toString());
    }
}
