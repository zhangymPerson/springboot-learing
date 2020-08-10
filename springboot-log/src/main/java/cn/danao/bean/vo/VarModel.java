package cn.danao.bean.vo;

import cn.danao.annotation.ValueAnnotation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * date 2020/8/10 16:09 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class VarModel {
    /**
     * 字符串，集合，map限制大小
     */
    @NotEmpty(message = "名字不能为空")
    // @Size(min = 2, max = 6, message = "名字长度在2-6位")
    @Length(min = 2, max = 6, message = "名字长度在2-6位")
    private String name;

    @Length(min = 3, max = 3, message = "pass 长度不为3")
    private String pass;

    /**
     * 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
     */
    @DecimalMin(value = "10", inclusive = true, message = "salary 低于10")
    private Integer salary;

    @Range(min = 5, max = 10, message = "range 不在范围内")
    private Integer range;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄不能小于18")
    @Max(value = 70, message = "年龄不能大于70")
    private Integer age;

    @Email
    private String email;

    @AssertTrue
    private Boolean flag;

    @Past
    private Date birthday;

    @Future
    private Date expire;

    @URL(message = "url 格式不对")
    private String url;

    @ValueAnnotation(value = "1,2,3",defaultValue = "默认值")
    private String value;
    //@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式

    /**
     * 字符串，集合，map限制大小
     */
    @Size(min = 2, max = 6, message = "长度在2-6位")
    private List<Integer> list;
}
