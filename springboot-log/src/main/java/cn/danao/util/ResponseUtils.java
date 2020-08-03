package cn.danao.util;

import cn.danao.exception.ResultBody;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Descrption controller响应
 */
@Slf4j
public class ResponseUtils {

    /**
     * 当data为json字符串得时候，不进行转换，防止json 转json转义字符得问题
     *
     * @param response 响应
     * @param data     写出得数据
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
            } else {
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
        // response.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            String res = gson.toJson(requestBody);
            log.info("返回的内容是[{}]", res);
            PrintWriter pw = response.getWriter();
            pw.write(JSONObject.toJSONString(requestBody));
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
