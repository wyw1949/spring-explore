package com.yoke.service;

import com.yoke.moel.UploadFileParams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IHandlerFileService {

    /**
     * 上传文件
     * @param params 参数
     * @return 处理结果
     */
    Object uploadFile(UploadFileParams params);

    /**
     * 下载文件
     * @param request 请求
     * @param response 响应
     */
    void download(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
