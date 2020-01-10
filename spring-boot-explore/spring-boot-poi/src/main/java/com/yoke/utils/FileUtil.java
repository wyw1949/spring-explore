package com.yoke.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
public class FileUtil {
    /**
     * 获取当前服务所在目录
     * @return 当前服务所在目录
     */
    public static String getUploadDirPath(){
        String jarFilePath = FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        log.info("服务jar文件路径：{}", jarFilePath);
        String parentPath;
        if (jarFilePath.contains("/lib")){
            parentPath = jarFilePath.contains(":") ? jarFilePath.substring(1, jarFilePath.lastIndexOf("/lib"))
                    : jarFilePath.substring(0, jarFilePath.lastIndexOf("/lib"));
        }else {
            parentPath = jarFilePath.contains(":") ? jarFilePath.substring(1, jarFilePath.lastIndexOf("/"))
                    : jarFilePath.substring(0, jarFilePath.lastIndexOf("/"));
        }
        return parentPath;
    }

    /**
     * 保存文件
     * @param uploadFile 上传的文件
     * @param fileStorePath 存储位置
     * @throws IOException 异常
     */
    public static void storeFile(MultipartFile uploadFile, String fileStorePath) throws IOException {
        if (uploadFile != null){
            String uploadFileName = uploadFile.getOriginalFilename();
            if (uploadFileName.endsWith(".zip") || uploadFileName.endsWith("ZIP")){
                File storeFile = new File(fileStorePath + "/" + uploadFileName);
                try(InputStream is = uploadFile.getInputStream();
                    OutputStream os = new FileOutputStream(storeFile)){
                    IOUtils.copy(is, os);
                    os.flush();
                } catch (IOException e) {
                    log.error("保存文件异常", e);
                    throw e;
                }
            }else {
                // 文件格式不正确
                log.error("上传文件格式不正确：{}，要求是zip格式", uploadFileName);
                throw new IOException("上传文件格式不正确：" + uploadFileName + "，要求是zip格式");
            }
        }else {
            // 抛出异常
            log.error("上传文件为空！");
            throw new IOException("上传文件为空");
        }
    }
}
