package cn.danao.server.impl;

import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;
import cn.danao.server.FileServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
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
    /**
     * 指定保存文件所在的文件夹
     */
    public static String defaultDirPath;

    static {
        try {
            defaultDirPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //public static String dirPath = "D:/test/";
    @Value("${spring.servlet.multipart.location}")
    public String dirPath;

    @Override
    public Map<String, Object> saveFile(Map<String, Object> params) {
        try {
            log.info("请求保存文件的接口，请求参数[{}]", params);
            log.info(dirPath + defaultDirPath);
            //file
            MultipartFile file = (MultipartFile) params.get("file");
            if (file != null) {
                try {
                    //将图片保存到指定的文件夹里
                    file.transferTo(new File(dirPath + file.getOriginalFilename()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
        return null;
    }

    @Override
    public Map<String, Object> downloadFile(Map<String, Object> params) {
        FileInputStream is = null;
        BufferedInputStream bs = null;
        try {
            //默认参数对
            Map<String, Object> result = new HashMap();
            //file
            String fileName = (String) params.get("file");
            if (StringUtils.isEmpty(fileName)) {
                throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs("文件名为空"));
            }
           // log.info("默认文件夹为 {}", dirPath);
            String fileAllName = dirPath + fileName;
            File file = new File(fileAllName);
            if (file == null || !file.exists()) {
                throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(fileName + "不存在"));
            }
            if (file.isDirectory()) {
                throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(fileName + "是文件夹，不是文件"));
            }
            is = new FileInputStream(file);
            bs = new BufferedInputStream(is);
            //fileName
            result.put("fileName", fileName);
            //bufferedInputStream
            result.put("bufferedInputStream", bs);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.EXCEPTION_INFO.fillArgs(e.getMessage()));
        }
    }
}
