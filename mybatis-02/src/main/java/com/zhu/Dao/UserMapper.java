package com.zhu.Dao;

import com.zhu.POJO.User;

import java.util.List;

//mapper
public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
