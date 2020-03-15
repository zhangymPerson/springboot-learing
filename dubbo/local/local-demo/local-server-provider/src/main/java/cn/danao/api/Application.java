package cn.danao.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * date 2020/3/15 9:16 <br/>
 * descriptionclass <br/>
 * 1.引入共有包
 * 2.实现业务服务的具体实现内容
 * 3.添加配置文件 声明注册的内容 配置中心的相关配置
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class Application {
    public static void main(String[] args) {
        String xmlFile = "provider.xml";
        log.info("客户服务端启动,并且注册到zookeeper,配置文件 {} ",xmlFile);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlFile);
        applicationContext.start();
        log.info("服务启动成功，输入任意字符退出");
        try {
            //防止程序退出
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
