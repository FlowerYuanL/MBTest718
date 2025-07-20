package com.lsxp.mapper;

import com.lsxp.pojo.User;
import com.lsxp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserAndPostMapperTest {

    UserAndPostMapper userAndPostMapper;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSession();
        userAndPostMapper = session.getMapper(UserAndPostMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }


    /*
    * 一对多查询
    * 嵌套结果
    * */
    @Test
    public void queryLists(){
        int id = 1;
        List<User> lists = userAndPostMapper.queryLists(id);
        for(User list : lists){
            System.out.println(list);
        }
    }


    /*
    * 一对多查询
    * 嵌套查询
    * */
    @Test
    public void queryLists2(){
        int id = 1;
        List<User> lists = userAndPostMapper.queryLists2(id);
        for(User list : lists){
            System.out.println(list);
        }
    }

    @Test
    public void queryLists3(){
        int id =1;
        List<User> lists = userAndPostMapper.queryLists3(id);
        for(User list : lists){
            System.out.println(list);
        }
    }

    @Test
    public void queryLists4(){
        int id =1;
        List<User> lists = userAndPostMapper.queryLists4(id);
        for(User list : lists){
            System.out.println(list);
        }
    }
}