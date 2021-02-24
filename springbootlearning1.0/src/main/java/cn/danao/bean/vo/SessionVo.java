package cn.danao.bean.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * date 2021/2/24 11:47 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class SessionVo {
    @NotBlank(message = "session_id不能为空")
    private String session_id;
}
