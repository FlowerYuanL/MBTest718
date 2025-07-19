package com.lsxp.mapper;

import com.lsxp.pojo.UserProfile;
import com.lsxp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileMapperTest {

    SqlSession session = null;
    UserProfileMapper mapper = null;

    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSession();
        mapper = session.getMapper(UserProfileMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
    @Test
    public void queryUserProfileById() {
        UserProfile profile = mapper.queryUserProfileById(1);
        System.out.println(profile);
    }
}