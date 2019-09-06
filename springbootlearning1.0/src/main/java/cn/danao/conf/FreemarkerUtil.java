package cn.danao.conf;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateModelException;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname FreemarkerUtil
 * @descriptionclass 1.freemark读取工具类
 * 2.其他说明
 * @createdate 2019/9/4 10:50
 * @since 1.0
 */
@Configuration
public class FreemarkerUtil {

    private static final freemarker.template.Configuration CONFIGURATION = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
    private static final String BASE_PACKAGE_PATH = "/freemarker";

    static {
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtils.class, BASE_PACKAGE_PATH));
        CONFIGURATION.setDefaultEncoding("UTF-8");
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);

        //增加自定义标签
        try {
            CONFIGURATION.setSharedVariable("test", "测试");
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }

    public static Template getTemplate(String templateName) {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据freemarker 模板 获取结果信息
     *
     * @param templateName 模板名称
     * @param dictMap      答案字典
     * @return 汇总字符串
     */
    public static String getStrResult(String templateName, Map<String, Object> dictMap) {
        Template template = FreemarkerUtil.getTemplate(templateName);
        StringWriter stringWriter = new StringWriter();
        try {
            assert template != null;
            template.process(dictMap, stringWriter);
            String result = stringWriter.toString();
            return result;
        } catch (TemplateException | IOException e) {
            System.out.println("获取freemarker模板结果信息出现异常\"");
            e.printStackTrace();
            return null;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }


    public static void main(String[] args) throws Exception {
        Template template = getTemplate("test.ftl");
        Map<String, Object> rootMap = new HashMap<>();
        rootMap.put("name", "郭啸天");
        StringWriter stringWriter = new StringWriter();
        template.process(rootMap, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
