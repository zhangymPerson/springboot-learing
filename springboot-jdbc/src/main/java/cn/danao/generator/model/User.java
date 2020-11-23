package cn.danao.generator.model;

public class User {
    private Integer pid;

    private String account;

    private String email;

    private String password;

    private String name;

    private Byte integrity;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getIntegrity() {
        return integrity;
    }

    public void setIntegrity(Byte integrity) {
        this.integrity = integrity;
    }
}