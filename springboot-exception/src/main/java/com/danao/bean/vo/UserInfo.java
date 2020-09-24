package com.danao.bean.vo;

/**
 * date 2020/9/24 9:53 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserInfo {
    /**
     * session_id
     */
    @NotBlank(message = "session_id不能为空")
    private String session_id;
    /**
     * 成员姓名
     */
    @NotBlank(message = "member_name不能为空")
    @Length(max = 10, message = "超过字数限制")
    private String member_name;
    /**
     * 成员id
     */
    private String member_id;
    /**
     * 性别
     */
    @NotBlank(message = "sex不能为空")
    private String sex;
    /**
     * 生日
     */
    @NotBlank(message = "birthday不能为空")
    private String birthday;
    /**
     * 关系
     */
    @NotBlank(message = "relation不能为空")
    private String relation;
    /**
     * 手机号
     */
    @NotBlank(message = "phone_num不能为空")
    private String phone_num;

    /**
     * 年龄
     */
    private String age;
    /**
     * 验证码
     */
    @NotBlank(message = "verifycode不能为空")
    private String verifycode;

    /**
     * 是否是默认成员
     */
    private String type;

}
