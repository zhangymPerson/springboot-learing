package cn.danao.server;

/**
 * date 2019/12/27 14:12 <br/>
 * descriptionclass <br/>
 * <p>
 * 测试切面的server
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface HelloServer {

    /**
     * 测试服务
     *
     * @return 输出一段话
     */
    String getServerStr();


    /**
     * 测试服务 含 其他方法
     *
     * @return 输出一段话
     */
    String getServerStr(String string);
}
