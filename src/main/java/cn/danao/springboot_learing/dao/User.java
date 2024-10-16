package cn.danao.springboot_learing.dao;

import java.io.Serializable;

/**
 * date 2024/10/16 17:29 <br>
 * description class User<br>
 *
 * @author zym
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private Long id;

    private String username;

    /**
     * 存储密码盐
     */
    private String passwordSalt;

    /**
     * 存储加密后的密码
     */
    private String password;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private String birthdate;

    /**
     * 存储头像URL地址
     */
    private String avatar;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 存储创建记录的用户ID
     */
    private String createBy;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 存储更新记录的用户ID
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    public User() {
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
