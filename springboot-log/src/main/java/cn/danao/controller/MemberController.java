package cn.danao.controller;

import cn.danao.bean.vo.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * date 2020/7/30 16:23 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@RequestMapping(value = "/member")
@RestController
@Slf4j
public class MemberController {

    @RequestMapping("/info")
    public String testVar(@Valid @RequestBody Member member) {
        log.info("member = [{}]", member);
        return "";
    }

    @GetMapping("/get")
    public String testVar1(
            @Size(min = 1, max = 10, message = "姓名长度必须为1到10") @RequestParam("name") String name,
            @Min(value = 10, message = "年龄最小为10") @Max(value = 100, message = "年龄最大为100") @RequestParam("age") Integer age,
            @Future @RequestParam("birth") @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date birth) {
        log.info("请求参数是{} {} {}", name, age, birth);
        return "success";
    }

}
