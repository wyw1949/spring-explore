package com.yoke.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtil {

    /**
     * 解压文件
     * @param sourcePath 文件所在源
     */
    public static void unzip(String sourcePath, String fileName) throws IOException {
        File sourceDir = new File(sourcePath);
        if (sourceDir.exists()){
            throw new IOException("解压文件失败，文件不存在");
        }
        File[] files = sourceDir.listFiles(pathname -> "template.zip".equals(pathname.getName()));
        if (files == null || files.length < 1){
            throw new IOException("解压文件失败，文件不存在");
        }
        File sourceFile = files[0];
        if (!sourceFile.exists() || !sourceFile.isFile()){
            throw new IOException("解压文件失败，文件不存在");
        }
        ZipFile zipFile = new ZipFile(sourceFile);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()){
            
        }
    }
}
