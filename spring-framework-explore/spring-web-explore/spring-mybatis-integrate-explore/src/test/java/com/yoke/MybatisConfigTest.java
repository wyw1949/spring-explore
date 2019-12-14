package com.yoke;

import com.yoke.config.MybatisConfig;
import com.yoke.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MybatisConfigTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MybatisConfig.class);
        StudentMapper mapper = ctx.getBean(StudentMapper.class);
        mapper.getStudentBySId("01");
    }

}
