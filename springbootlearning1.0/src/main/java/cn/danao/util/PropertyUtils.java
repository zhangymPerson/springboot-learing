package cn.danao.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * date 2020/2/20 15:26 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class PropertyUtils {

    private static Properties properties = new Properties();
    private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);

    static {
        InputStream inputStream = null;
        try {
            String baseDir = System.getProperty("nacos.home");
            if (StringUtils.isNotBlank(baseDir)) {
                inputStream = new FileInputStream(baseDir + "/conf/application.properties");
            } else {
                inputStream = PropertyUtils.class
                        .getResourceAsStream("/application.properties");
            }
            properties.load(inputStream);
        } catch (Exception e) {
            log.error("read property file error:" + e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static List<String> getPropertyList(String key) {
        List<String> valueList = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String value = properties.getProperty(key + "[" + i + "]");
            if (StringUtils.isBlank(value)) {
                break;
            }

            valueList.add(value);
        }

        return valueList;
    }

}
