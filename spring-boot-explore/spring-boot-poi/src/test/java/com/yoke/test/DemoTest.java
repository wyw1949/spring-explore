package com.yoke.test;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
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
}
