package com.yoke.moel;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileParams {
    /**
     * 文件
     */
    private MultipartFile file;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 库id
     */
    private String libId;
}
