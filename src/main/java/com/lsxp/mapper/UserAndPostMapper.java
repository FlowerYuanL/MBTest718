package com.lsxp.mapper;

import com.lsxp.pojo.Post;
import com.lsxp.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserAndPostMapper {

    /*一对多查询*/

    /*嵌套结果*/
    List<User> queryLists(Integer userId);

    /*嵌套查询*/
    List<User> queryLists2(Integer userId);

    /*注释模式——嵌套查询*/
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "id",property = "postList",
                    many = @Many(select="com.lsxp.mapper.UserAndPostMapper.queryPost"))
    })
    List<User> queryLists3(Integer userId);

    @Select("select * from posts where user_id = #{id}")
    List<Post> queryPost(Integer id);

    /*注释模式——嵌套结果*/
    @Select("select " +
            "u.id uid,u.username uname,p.id pid,p.user_id puid,p.content pcontent" +
            " from users u inner join posts p" +
            " on u.id = p.user_id where u.id=#{user_id}")
    @Results({
            @Result(property = "id",column = "uid"),
            @Result(property = "username",column = "uname"),
            @Result(property = "postList.id" , column = "pid"),
            @Result(property = "postList.userId",column = "puid"),
            @Result(property = "postList.content",column = "pcontent")
    })
    List<User> queryLists4(@Param("user_id") Integer userId);
}
