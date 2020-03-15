package cn.danao.api.server.impl;

import cn.danao.api.server.HelloService;
import cn.danao.api.server.HelloUseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date 2020/3/15 10:03 <br/>
 * descriptionclass <br/>
 * 测试远程服务的调用
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Service
@Slf4j
public class HelloUseServiceImpl implements HelloUseService {

    @Autowired
    private HelloService helloService;

    public String sayWord(String word) {
        log.info("消费者自己的方法。参入参数 {}",word);
        return helloService.sayHello(word);
    }
}
