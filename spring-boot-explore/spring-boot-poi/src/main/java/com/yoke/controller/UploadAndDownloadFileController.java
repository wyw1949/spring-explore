package com.yoke.controller;

import com.yoke.moel.UploadFileParams;
import com.yoke.service.IHandlerFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/file")
public class UploadAndDownloadFileController {

    @Autowired
    private IHandlerFileService handlerFileService;

    @PostMapping("/upload")
    public Object uploadFile(UploadFileParams fileParams){
        handlerFileService.uploadFile(fileParams);
        return null;
    }

    @GetMapping("/download")
    public Object downloadFile(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<>();
        try {
            handlerFileService.download(request, response);
            result.put("code", "200");
            result.put("message", "SUCCESS");
        } catch (IOException e) {
            result.put("code", "500");
            result.put("message", "FAILED");
            log.error("下载失败", e);
        }
        return result;
    }
}
