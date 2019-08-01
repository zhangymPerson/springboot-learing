package cn.danao.server.impl;

import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;
import cn.danao.server.FileServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname FileServerImpl
 * @descriptionclass 1.文件服务类
 * 2.****************
 * @createdate 2019/8/1 22:46
 * @since 1.0
 */
@Service
@Slf4j
public class FileServerImpl implements FileServer {
    @Override
    public Map<String, Object> saveFile(Map<String, Object> params) {
        try {
            log.info("请求保存文件的接口，请求参数[{}]", params);
            //file
            MultipartFile file = (MultipartFile) params.get("file");
            if (file != null) {
                String filePath = "D:/test/";
                try {
                    //将图片保存到static文件夹里
                    file.transferTo(new File(filePath + file.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
        return null;
    }
}
