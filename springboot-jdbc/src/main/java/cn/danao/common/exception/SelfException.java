package cn.danao.common.exception;

import cn.danao.common.result.ErrorCode;

/**
 * @author zhang
 * @version 1.0
 * @classname SelfException
 * @descriptionclass
 * 1.自定义项目异常
 * @createdate 2019/3/19
 * @since 1.0
 */
public class SelfException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

	public SelfException(ErrorCode errorCode) {
		super(errorCode.toString());
		this.errorCode = errorCode;
	}

	public SelfException(ErrorCode errorCode, Exception ex) {
		super(errorCode.toString());
		this.errorCode = errorCode;
		this.errorCode.setMsg(this.errorCode.getMsg() + "\\r\\n" + ex.getMessage());
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
