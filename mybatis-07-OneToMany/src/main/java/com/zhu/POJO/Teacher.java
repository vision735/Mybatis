package com.zhu.POJO;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String t_name;
//    一个老师拥有多个学生
    private List<Student> students;
}
