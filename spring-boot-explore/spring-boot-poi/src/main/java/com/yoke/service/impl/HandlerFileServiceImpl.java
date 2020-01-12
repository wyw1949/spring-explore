package com.yoke.service.impl;

import com.yoke.moel.PersonEntity;
import com.yoke.moel.UploadFileParams;
import com.yoke.service.IHandlerFileService;
import com.yoke.utils.FileUtil;
import com.yoke.utils.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> result = new HashMap<>();
        result.put("code", "200");
        result.put("message", "SUCCESS");
        // 获取应用所在目录
        String parentPath = FileUtil.getUploadDirPath();
        log.info("服务所在位置目录：{}", parentPath);

        // 创建文件上传目录
        String userId = params.getUserId();
        String libId = params.getLibId();
        log.info("上传文件用户：{}， 所在库：{}", userId, libId);
        String fileStorePath = parentPath + "/" + libId + "/" + userId;
        File fileStoreDir = new File(fileStorePath);

        // 创建好目录之后，将上传的文件写入
        MultipartFile uploadFile = params.getFile();
        try {
            // 创建上传目录
            FileUtils.forceMkdir(fileStoreDir);
            // 清空文件夹
            FileUtils.cleanDirectory(fileStoreDir);
            // 创建好目录之后，将上传的文件写入
            FileUtil.storeFile(uploadFile, fileStorePath);
        } catch (IOException e) {
            log.error("保存文件失败。", e);
            result.put("code", "500");
            result.put("message", e);
        }
        return result;
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

    /**
     * 批量导入人员
     * @param libId 库id
     * @param userId 用户id
     * @return 处理结果
     */
    @Override
    public Object batchImport(String libId, String userId) {
        // 解压上传的文件
        String fileStorePath = FileUtil.getUploadDirPath() + "/" + libId + "/" + userId;
        try {
            String unzipPath = ZipUtil.unzip(fileStorePath);
            // 解析上传的文件
            List<PersonEntity> personEntities = analysisPersonFileToPersonEntities(unzipPath);
            // todo 保存人员信息

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<PersonEntity> analysisPersonFileToPersonEntities(String unzipPath) {
        // todo
        return null;
    }


}
