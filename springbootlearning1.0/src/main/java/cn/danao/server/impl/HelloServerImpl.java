package cn.danao.server.impl;

import cn.danao.aop.RunTime;
import cn.danao.server.HelloServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date 2019/12/27 14:14 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
@Slf4j
public class HelloServerImpl implements HelloServer {
    /**
     * 服务测试
     * 测试 切入注解 可以实现切入
     *
     * @return 返回一段话
     */
    @RunTime(desc = "测试注解")
    @Override
    public String getServerStr() {
        log.info("调用服务类不带参数...");
        getStr();
        return "调用服务";
    }

    @Override
    public String getServerStr(String string) {
        log.info("调用服务类参数[{}]...", string);
        String s = getStr();
        return s + string;
    }

    /**
     * 此处的注解未被切入
     * <p>
     * server的实现方法 没有被切入
     *
     * @return 返回一句话
     */
    @RunTime(desc = "getStr")
    private String getStr() {
        log.info("自定义方法执行,测试注解切入");
        return "调用自定义方法";
    }

}
