package com.lsxp.mapper;

import com.lsxp.pojo.User;

import java.util.List;

public interface UserAndPostMapper {

    /*嵌套结果*/
    List<User> queryLists(Integer userId);

    /*嵌套查询寻*/
    List<User> queryLists2(Integer userId);
}
