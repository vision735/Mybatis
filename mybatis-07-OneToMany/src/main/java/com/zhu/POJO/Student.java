package com.zhu.POJO;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String s_name;
//    学生需要关联一个老师
//    private Teacher teacher;
    private int tid;
}
