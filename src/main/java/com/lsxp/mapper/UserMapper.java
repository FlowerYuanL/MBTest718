package com.lsxp.mapper;

import com.lsxp.pojo.User;

import java.util.List;

public interface UserMapper {


    List<User> queryAll();

    User queryUserAndProfileById(int id);

    User queryUserAndProfileByIdResult(int id);

    User findUserById(int id);

    void updateUser(User user);
}
