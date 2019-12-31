package cn.danao.conf;

import cn.danao.server.AopTestServer;
import cn.danao.server.impl.AopTestServerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * date 2019/12/31 12:05 <br/>
 * descriptionclass <br/>
 * <p>
 * 配置自定义服务类
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class BeanConfig {

    /**
     * 注释@Bean 与 AopTestServerImpl中的 @Server 冲突
     *
     * @return 返回bean对象
     */
    @Bean
    public AopTestServer getAopTestServer() {
        return new AopTestServerImpl();
    }
}
