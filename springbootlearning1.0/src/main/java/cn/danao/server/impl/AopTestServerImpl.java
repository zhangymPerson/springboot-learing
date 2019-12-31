package cn.danao.server.impl;

import cn.danao.aop.RunTime;
import cn.danao.server.AopTestServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date 2019/12/31 11:58 <br/>
 * descriptionclass <br/>
 * <p>
 * 一种 @Configuration 类中 @Bean 方式注入
 * <p>
 * 一种 @Service注入
 * <p>
 * 一起注入会报错
 * Parameter 2 of constructor in cn.danao.controller.StartController required a single bean, but 2 were found:
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
//@Service
@Slf4j
public class AopTestServerImpl implements AopTestServer {
    @Override
    @RunTime(desc = "service中继承方法")
    public void aop() {
        log.info("测试切面服务；aop()");
        self();
    }

    /**
     * 不管是 @Bean注入还是@Server注入，切面都切不到这个方法
     */
    @RunTime(desc = "service实现类自定义方法")
    public void self() {
        log.info("测试切面服务，self()");
    }
}
