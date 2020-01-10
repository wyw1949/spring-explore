package com.yoke.test;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class DemoTest {
    @Test
    public void testMimetypesFileTypeMap(){
        System.out.println(DemoTest.class.getResource("/template/template.zip").getFile());
        System.out.println(new MimetypesFileTypeMap()
                .getContentType(DemoTest.class.getResource("/template/template.zip").getFile()));
        System.out.println(getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
        System.out.println(File.separator);
    }

    @Test
    public void testDeleteDir() throws IOException {
        FileUtils.cleanDirectory(new File("C:\\Users\\yoke\\Desktop\\template"));
    }

    @Test
    public void testSubString() {
        String path = "/serviceId/lib";
        System.out.println(path.substring(0, path.lastIndexOf("/lib")));
    }

    @Test
    public void testFileList() {
        File dir = new File("C:\\Users\\liyu\\Desktop\\person_batch_import_template");
        dir.list((dir1, name) -> {
            System.out.println(dir1.getName() + "---" + name);
            return true;
        });

    }
}
