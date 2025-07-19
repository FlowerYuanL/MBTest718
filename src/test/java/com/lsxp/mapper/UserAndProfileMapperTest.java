package com.lsxp.mapper;

import com.lsxp.pojo.User;
import com.lsxp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserAndProfileMapperTest {

    UserAndProfileMapper userAndProfileMapper;
    SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtil.getSession();
        userAndProfileMapper = sqlSession.getMapper(UserAndProfileMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void queryByName() {
        String name = "o";
        System.out.println(name);
        List<User> users = userAndProfileMapper.queryByName(name);
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}