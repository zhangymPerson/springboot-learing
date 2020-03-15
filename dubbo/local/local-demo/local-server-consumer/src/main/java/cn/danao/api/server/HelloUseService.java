package cn.danao.api.server;

/**
 * date 2020/3/15 10:00 <br/>
 * descriptionclass <br/>
 * 测试远程服务
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface HelloUseService {
    /**
     * 消费者自己的服务
     * 服务实现调用 提供者的 远程服务
     * @param word 表达的内容
     * @return 远程返回的值
     */
    String sayWord(String word);
}
