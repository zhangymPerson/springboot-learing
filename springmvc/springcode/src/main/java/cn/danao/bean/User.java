package cn.danao.bean;

/**
 * @author zhang
 * @version 1.0
 * @classname User
 * @descriptionclass class describe
 * 1.bean实体类
 * 2.****************
 * @createdate 2019/4/25
 * @since 1.0
 */
public class User {

	private Integer userId;

	private String userName;

	private Integer age;

	private String remark;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", age=" + age +
				", remark='" + remark + '\'' +
				'}';
	}
}
