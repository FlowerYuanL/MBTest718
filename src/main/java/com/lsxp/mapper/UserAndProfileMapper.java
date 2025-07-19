package com.lsxp.mapper;

import com.lsxp.pojo.User;

import java.util.List;

public interface UserAndProfileMapper {

    List<User>  queryByName(String name);

}
