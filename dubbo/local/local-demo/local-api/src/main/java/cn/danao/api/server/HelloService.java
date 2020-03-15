package cn.danao.api.server;

import java.util.Map;

/**
 * date 2020/3/15 8:11 <br/>
 * descriptionclass <br/>
 * 创建项目公用的接口规范
 * 服务端和客户端都需要引入
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface HelloService {

    /**
     * 简单服务 调用 返回 hello + word
     *
     * @param word 要表达的内容
     * @return hello + word
     */
    String sayHello(String word);

    /**
     * 测试较为复杂的服务调用
     *
     * @param params 测试参数
     * @return 测试结果
     */
    Map<String, Object> getInfo(Map<String, Object> params);
}