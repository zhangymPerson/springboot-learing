package cn.danao.server;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname FileServer
 * @descriptionclass
 * 1.文件处理
 * 2.****************
 * @createdate 2019/8/1 22:43
 * @since 1.0
 */
public interface FileServer {

    /**
     * 保存文件
     * @param params
     * @return
     */
    Map<String,Object> saveFile(Map<String, Object> params);

    /**
     * 文件下载
     * @param params
     * @return
     */
    Map<String,Object> downloadFile(Map<String, Object> params);


    /**
     * 测试request.getRead()
     * @param request
     * @return
     */
    Map<String,Object> testRequest(HttpServletRequest request);

}
