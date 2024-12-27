package cn.danao.springboot_learing.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * date 2024/10/16 17:29 <br>
 * description class User<br>
 *
 * @author zym
 */
public record User(
        Integer id,
        String username,
        String passwordSalt,
        String password,
        String email,
        String mobile,
        Gender gender,
        LocalDate birthdate,
        String avatar,
        LocalDateTime createTime,
        Integer createBy,
        LocalDateTime updateTime,
        Integer updateBy,
        String remark
) {
    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public User {
        // 可以在这里添加自定义的构造函数逻辑，例如验证
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
}
