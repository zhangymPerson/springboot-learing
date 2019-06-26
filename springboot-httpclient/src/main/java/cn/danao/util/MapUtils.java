package cn.danao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname MapUtils
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/5/27 11:50
 * @since 1.0
 */
public class MapUtils {

    public static Logger logger = LoggerFactory.getLogger(MapUtils.class);
    public  static String hashmapToString(Map map) {
      StringBuffer result = new StringBuffer("");
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            result.append(key.toString() +":" );
            Object val = entry.getValue();
            result.append(key.toString() + ";");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("abc","sd");
        map.put("ew","eew");
        System.out.println(hashmapToString(map));
        logger.info(String.format("要请求的url %s ","http://39.104.82.22:8080/danao/test"));
        logger.info(String.format("参数:%s",MapUtils.hashmapToString(map)));
    }
}
