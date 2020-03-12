package cn.danao.listener;

import cn.danao.util.InetUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * date 2020/2/20 15:19 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class StartingSpringApplicationRunListener implements SpringApplicationRunListener, Ordered {
    /**
     * nacos local ip
     */
    public static final String LOCAL_IP = InetUtils.getSelfIp();

    /**
     * 本地ip
     */
    private static final String LOCAL_IP_PROPERTY_KEY = "project.local.ip";


    /**
     * 自己实现的类必须含有以下构造函数，才能被Boot调用
     *
     * @param application
     * @param args
     */
    public StartingSpringApplicationRunListener(SpringApplication application, String... args) {
        log.debug("监听器正在初始化...");
    }

    @Override
    public void starting() {
        log.debug("刚执行run方法时 starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.debug("环境建立好时候 environmentPrepared");
        log.debug("ip = {}", LOCAL_IP);
        System.setProperty(LOCAL_IP_PROPERTY_KEY, LOCAL_IP);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.debug("上下文建立好的时候 ");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.debug("上下文载入配置时候");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
