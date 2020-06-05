package cn.danao.test.base;

import cn.danao.bean.strinfo.A;
import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/6/5 14:52 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class BeetlTest {

    @Test
    public void test() {
        String t = "hello ${key}";
        Map<String, Object> map = new HashMap<>();
        map.put("key", "key");
        System.out.println(execBeetl(t, map));
        String t1 = "a.id = ${a.id} , a.name = ${a.name} <%\n" +
                "for(str in a.list){\n" +
                "        print(str);" +
                "}\n" +
                "%>";
        map.put("a", new A(3));


        execBeetlFile("test.js", map);

        System.out.println(execBeetl(t1, map));
    }

    public String execBeetl(String templateStr, Map<String, Object> map) {
        //初始化代码
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        //获取模板
        Template t = gt.getTemplate(templateStr);
        t.binding(map);
        return t.render();
    }

    public String execBeetlFile(String filePath, Map<String, Object> map) {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("beetl");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate(filePath);
        t.binding(map);
        String str = t.render();
        log.info("读取文件[{}],传入map=[{}]\n拼写结果[{}]",filePath,map,str);
        return str;
    }
}
