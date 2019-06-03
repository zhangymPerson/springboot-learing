package cn.danao.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author danao
 * @version 1.0
 * @classname PropertyPlaceholder
 * @descriptionclass
 *
 * 1.获取配置文件内容测试  读取自定义 test.properties
 * 2.配置文件
 * @createdate 2019/6/3 16:32
 * @since 1.0
 */
public class PropertyPlaceholder extends PropertyPlaceholderConfigurer {

    private static Map<String,String> propertyMap;

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

    //static method for accessing context properties
    public static Object getProperty(String name) {
        return propertyMap.get(name);
    }

    /**
     * return str
     * @param name key
     * @return str
     */
    public static String getPropertyForStr(String name) {
        return String.valueOf(getProperty(name));
    }


}
