package cn.danao.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author danao
 * @version 1.0
 * @classname UrlInfo
 * @descriptionclass
 * 1.读取配置文件中远程访问的接口
 * 2.路由地址用  ;  分割
 * @createdate 2019/5/24 16:13
 * @since 1.0
 */
@PropertySource("classpath:url-info.properties")
@Component
public class UrlInfo {

    @Value("${server.host}")
    public String host;

    @Value("${server.port}")
    public String port;

    @Value("${server.get.route}")
    public String getRoute;


    @Value("${server.post.route}")
    public String postRoute;

    @Override
    public String toString() {
        return "UrlInfo{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", getRoute='" + getRoute + '\'' +
                ", postRoute='" + postRoute + '\'' +
                '}';
    }
}

