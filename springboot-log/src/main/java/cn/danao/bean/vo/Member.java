package cn.danao.bean.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * date 2020/7/30 16:19 <br/>
 * description class <br/>
 * 参数校验对象测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class Member {

    private String id;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Email
    private String email;

    @NotEmpty
    private String phoneNum;

    @Size(min = 0, max = 150, message = "年龄介于0-150")
    private int age;
}
