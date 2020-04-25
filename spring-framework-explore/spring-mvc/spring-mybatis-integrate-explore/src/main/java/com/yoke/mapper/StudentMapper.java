package com.yoke.mapper;

import com.yoke.model.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    Student getStudentBySId(@Param("sid") String sid);
}
