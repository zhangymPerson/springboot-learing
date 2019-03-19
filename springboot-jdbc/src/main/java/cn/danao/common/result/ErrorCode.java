package cn.danao.common.result;

/**
 * @author zhang
 * @version 1.0
 * @classname ErrorCode
 * @descriptionclass 
 * 1.构造错误码
 * 2.单例
 * @createdate 2019/3/19
 * @since 1.0
 */
public class ErrorCode {
	/**
	 * 错误码
	 */
	private int code;
	/**
	 * 错误信息
	 */
	private String msg;


	public static ErrorCode SUCCESS = new ErrorCode(0, "success");
	public static ErrorCode COMMON_SERVER_ERROR = new ErrorCode(500100, "服务端异常");//服务端异常
	public static ErrorCode LOGIN_BORRME_USER_NOT_FOUND = new ErrorCode(500227, "该用户不存在");

	private ErrorCode(){
		super();
	}
	
	private ErrorCode(int code,String msg){
		this.code =code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ErrorCode{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				'}';
	}
}
