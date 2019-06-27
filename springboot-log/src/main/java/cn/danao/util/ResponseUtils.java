package cn.danao.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cn.danao.exception.ResultBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Descrption controller响应
 */
public class ResponseUtils {

    /**
     * 当data为json字符串得时候，不进行转换，防止json 转json转义字符得问题
     * @param response 响应
     * @param data 写出得数据
     * @param isToJson 是否转化为json
     */
    public static void write(HttpServletResponse response, Object data, boolean isToJson) {
        //response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            PrintWriter pw = response.getWriter();
            if (isToJson) {
                pw.write(gson.toJson(data));
            }else {
                pw.write(data.toString());
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(HttpServletResponse response, Object data) {
        response.setCharacterEncoding("utf-8");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            ResultBody requestBody = new ResultBody(data);
            PrintWriter pw = response.getWriter();
            pw.write(gson.toJson(requestBody));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            ResultBody requestBody = new ResultBody();
            PrintWriter pw = response.getWriter();
            pw.write(gson.toJson(requestBody));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(HttpServletResponse response, ResultBody requestBody) {
        response.setCharacterEncoding("utf-8");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            PrintWriter pw = response.getWriter();
            pw.write(gson.toJson(requestBody));
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ResultBody resultBody = new ResultBody("111");
        System.out.println(resultBody.getCode());
    }
}
