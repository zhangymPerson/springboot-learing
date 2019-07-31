package cn.danao.util.http.resttemplate;

import cn.danao.util.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname RestTemplateUtil
 * @descriptionclass 1.类的作用 使用RestTemplate 进行远程互联网访问
 * 2.其他说明
 * @createdate 2019/5/24 16:29
 * @since 1.0
 */
@Component
@Slf4j
public class RestTemplateUtil {

    private static RestTemplate restTemplate = new RestTemplate();

    private static String URL = "http://host:port";


    public String doGet(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    public String doGet(String url, Map<String, Object> map) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        String reallyUrl = url;
        ResponseEntity responseEntity;
        //如果存在參數
        if (!map.isEmpty()) {
            for (Map.Entry<String, Object> e : map.entrySet()) {
                //构建查询参数
                builder.queryParam(e.getKey(), e.getValue());
            }
            //拼接好参数后的URl//test.com/url?param1={param1}&param2={param2};
            reallyUrl = builder.build().toString();
        }
        log.info(reallyUrl);
        return restTemplate.getForObject(reallyUrl, String.class);

    }

    /**
     * todo 尚未实现
     * @param url
     * @return
     */
    public String doPost(String url) {
        return null;
    }

    public String doPost(String url, Map<String, Object> map) {
        return null;
    }

    public static void main(String[] args) {
    }
}
