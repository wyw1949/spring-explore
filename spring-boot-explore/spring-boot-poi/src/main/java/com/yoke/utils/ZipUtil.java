package com.yoke.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {

    /**
     * 解压文件
     * @param sourcePath 文件所在源
     */
    public static String unzip(String sourcePath) throws IOException {
        File sourceDir = new File(sourcePath);
        if (!sourceDir.exists()){
            throw new IOException("解压文件失败，文件不存在");
        }
        File[] files = sourceDir.listFiles(pathname -> pathname.getName().endsWith(".zip") || pathname.getName().endsWith("ZIP"));
        if (files == null || files.length < 1){
            throw new IOException("解压文件失败，文件不存在");
        }
        File sourceFile = files[0];
        if (!sourceFile.exists() || !sourceFile.isFile()){
            throw new IOException("解压文件失败，文件不存在");
        }
        // 创建解压文件目录
        String unzipDir = sourceDir + "/unzip";
        FileUtils.forceMkdir(new File(unzipDir));
        // 解压文件
        try (ZipFile zipFile = new ZipFile(sourceFile)){
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry zipEntry = entries.nextElement();
                if (zipEntry.isDirectory()){
                    // 是文件夹则创建文件夹
                    FileUtils.forceMkdir(new File(unzipDir + "/" + zipEntry.getName()));
                }else {
                    // 是文件则使用流输出到相应位置
                    try (InputStream fileIs = zipFile.getInputStream(zipEntry);
                         FileOutputStream os = new FileOutputStream(new File(unzipDir + "/" + zipEntry.getName()))){
                        IOUtils.copy(fileIs, os);
                        os.flush();
                    }
                }
            }
        }
        return unzipDir;
    }
}
