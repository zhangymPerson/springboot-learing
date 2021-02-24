package cn.danao.bean.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * date 2021/2/24 15:02 <br/>
 * description class <br/>
 * 成员VO对象
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class MemberVo {

    @NotBlank(message = "姓名name字段不能为空")
    @Size(min = 1, max = 10, message = "姓名长度必须为1到10")
    private String name;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @Length(max = 11, min = 11, message = "手机号只能为11位")
    private String num;

    @NotNull(message = "年龄不能为空")
    @Max(value = 150, message = "年龄不能超过150岁")
    @Min(value = 0, message = "年龄不能小于0")
    private Integer age;
}
