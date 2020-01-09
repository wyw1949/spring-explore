package com.yoke.service.impl;

import com.yoke.moel.UploadFileParams;
import com.yoke.service.IHandlerFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@Service
public class HandlerFileServiceImpl implements IHandlerFileService {
    /**
     * 上传文件
     *  文件上传到服务jar包所在目录的upload文件夹下，并根据根据libId和userId分类存放
     *  解压文件到压缩文件所在目录的unzip目录下，以压缩文件名作为解压文件夹
     * @param params 参数
     * @return 执行结果
     */
    @Override
    public Object uploadFile(UploadFileParams params) {
        String jarFilePath = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
        log.info("服务jar文件路径：{}", jarFilePath);
        String parentPath;
        if (StringUtils.isNotBlank(jarFilePath) && jarFilePath.contains(":")){
            parentPath = jarFilePath.substring(1, jarFilePath.lastIndexOf("/"));
        }else {
            parentPath = jarFilePath.substring(0, jarFilePath.lastIndexOf("/"));
        }
        log.info("文件上传存储父路径：{}", parentPath);
        String userId = params.getUserId();
        String libId = params.getLibId();
        log.info("上传文件用户：{}， 所在库：{}", userId, libId);
        String fileStorePath = parentPath + "/" + libId + "/" + userId;
        File fileStoreDir = new File(fileStorePath);
        if (!fileStoreDir.exists()){
            boolean mkdirsFlag = fileStoreDir.mkdirs();
            if (!mkdirsFlag){
                // 抛异常或返回
                log.info("创建目录（{}）失败", fileStorePath);
            }
        }
        File[] fileList = fileStoreDir.listFiles();
        if (fileList != null && fileList.length > 0){
            //清空文件夹
            try {
                FileUtils.cleanDirectory(fileStoreDir);
            } catch (IOException e) {
                log.error("清空文件夹（{}）异常", fileStorePath);
            }
        }

        // 创建好目录之后，将上传的文件写入
        MultipartFile uploadFile = params.getFile();
        if (uploadFile != null){
            String uploadFileName = uploadFile.getName();
            if (uploadFileName.endsWith(".zip") || uploadFileName.endsWith("ZIP")){
                File storeFile = new File(fileStorePath + "/" + uploadFileName);
                try(InputStream is = uploadFile.getInputStream();
                OutputStream os = new FileOutputStream(storeFile)){
                    IOUtils.copy(is, os);
                    os.flush();
                } catch (IOException e) {
                    log.error("保存文件异常", e);
                }
            }else {
                // 文件格式不正确
                log.error("上传文件格式不正确：{}，要求是zip格式", uploadFileName);
            }
        }else {
            // 抛出异常
            log.error("上传文件为空！");
        }
        return null;
    }

    /**
     * 下载模板
     * @param request 请求
     * @param response 响应
     * @throws IOException 异常
     */
    @Override
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (OutputStream os = response.getOutputStream();
             InputStream templateStream = getClass()
                     .getResourceAsStream("/template/template.zip")) {
            // 获取响应类型
            String type = new MimetypesFileTypeMap().getContentType("template.zip");
            response.addHeader("Content-Type", type);
            response.setHeader("Content-Disposition", "attachment;filename=template.zip");
            IOUtils.copy(templateStream, os);
        }
    }
}
