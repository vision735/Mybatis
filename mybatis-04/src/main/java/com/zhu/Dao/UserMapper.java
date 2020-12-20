package com.zhu.Dao;

import com.zhu.POJO.User;

import java.util.List;
import java.util.Map;

//mapper
public interface UserMapper {

    User getUserById(int id);

    //分页1
    List<User> getUserByLimit(Map<String,Integer> map);

//    分页2

    List<User> getUserByRowBounds();
}
