package cn.danao.common.result;

/**
 * @author zhang
 * @version 1.0
 * @classname Result
 * @descriptionclass
 * 1.定义返回的结果类
 * 2.将返回的数据统一包装成 {"error":0,"msg":"success","data":""}
 * @createdate 2019/3/19
 * @since 1.0
 */
public class Result<T> {

	/**
	 * 构造返回的状态值
	 */
	private int code;

	/**
	 * 返回的状态信息
	 */
	private String msg;

	/**
	 * 返回的数据
	 */
	private T data;

	/**
	 * 成功的时候调用
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return new Result<>(data);
	}

	/**
	 * 失败的时候调用
	 * @param errorCode
	 * @return
	 */
	public static Result error(ErrorCode errorCode){
		return new Result(errorCode);
	}

	private Result(T data){
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}

	private Result(ErrorCode errorCode){
		if(errorCode == null){
			return;
		}
		this.code = errorCode.getCode();
		this.msg = errorCode.getMsg();
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}
