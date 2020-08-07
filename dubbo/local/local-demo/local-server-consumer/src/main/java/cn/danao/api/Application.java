package cn.danao.api;

import cn.danao.api.server.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * date 2020/3/15 9:30 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class Application {
    public static void main(String[] args) {
        String xmlFile = "consumer.xml";
        log.info("远程调用客户端启动");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlFile);
        context.start();
        HelloService service = context.getBean(HelloService.class); // 获取远程服务代理
        String hello = service.sayHello("汉字测试"); // 执行远程方法
        System.out.println(hello);
    }
}
