package cn.danao.springbootshiro.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * date 2019/12/31 17:20 <br/>
 * descriptionclass <br/>
 * 用户本体
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * id
     */
    String Id;
    /**
     * 用户名
     */
    String username;
    /**
     * 密码
     */
    String password;
}
