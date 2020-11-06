package cn.danao.conf;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * date 2020/10/10 15:40 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class RestTemplateBean {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().setReadTimeout(Duration.ofSeconds(1800))
                .setConnectTimeout(Duration.ofSeconds(1800))
                .build();
    }

}
