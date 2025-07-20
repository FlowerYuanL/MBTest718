package com.lsxp.mapper;

import com.lsxp.pojo.User;
import com.mysql.cj.xdevapi.Column;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserAndProfileMapper {

    List<User>  queryByName(String name);

    @Select("SELECT * FROM users where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "id",property = "userProfile",
            /*注意在此处调用的函数时之前使用xml映射的方式书写的，就是简单的通过id查询user_profiles表*/
            one = @One(select = "com.lsxp.mapper.UserProfileMapper.queryUserProfileById"))
    })
    User queryAllByIdUser(@Param("id") int id);

    @Select("SELECT" +
            " u.id uid,u.username uname,p.user_id pid,p.real_name pname,p.age page" +
            " from users u left join user_profiles p " +
            "on u.id = p.user_id " +
            "where u.id = #{id}"
    )
    @Results({
            @Result(column = "uid" , property = "id"),
            @Result(column = "uname" , property = "username"),
            @Result(column = "pid" , property = "userProfile.userId"),
            @Result(column = "pname" , property = "userProfile.realName"),
            @Result(column = "page" , property = "userProfile.age")
    })
    User queryUserById(@Param("id") int id);
}
