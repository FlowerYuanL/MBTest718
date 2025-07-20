package com.lsxp.mapper;

import com.lsxp.pojo.UserGroup;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserGroupMapper {

    /*多表查询*/
    /* 包含如下表：User、GroupList、UserGroup
    * */

    List<UserGroup> getUserGroup();

    List<UserGroup> getUserGroup2();

    @Select("select * from users where id = ")
    List<UserGroup> getUserGroup3();
}
