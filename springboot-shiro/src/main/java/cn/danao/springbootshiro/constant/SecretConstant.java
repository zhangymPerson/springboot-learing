package cn.danao.springbootshiro.constant;

/**
 * date 2020/1/2 14:35 <br/>
 * descriptionclass <br/>
 * <p>
 * jwt测试使用常量
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class SecretConstant {

    //签名秘钥
    public static final String BASE64SECRET = "danao";

    //超时毫秒数（默认30分钟）
    public static final int EXPIRESSECOND = 60000;

    //用于JWT加密的密匙
    public static final String DATAKEY = "jwt";
}
