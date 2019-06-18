package cn.danao.bean;

/**
 * @author danao
 * @version 1.0
 * @classname ResultCode
 * @descriptionclass
 * 1.返回结果
 * 2.其他说明
 * @createdate 2019/5/27 14:27
 * @since 1.0
 */
public class ResultCode {

    private int code;

    private String msg;

    private Object data;

    //正确返回
    public static ResultCode SUCCESS = new ResultCode(200,"SUCCESS","请求成功!");
    //错误返回
    public static ResultCode ERROR = new ResultCode(200,"SUCCESS","请求错误!");

    private ResultCode(){
        super();
    }


    private ResultCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private ResultCode(int code, String msg, Object  data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultCode getResultCode(Object data){
        return new ResultCode(200,"SUCCESS",data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
}
