package com.zhu.Dao;

import com.zhu.POJO.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher();

    Teacher getTeacherById(@Param("id") int id);

    Teacher getTeacherById2(@Param("id") int id);
}
