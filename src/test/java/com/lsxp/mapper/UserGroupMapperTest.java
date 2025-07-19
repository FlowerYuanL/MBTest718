package com.lsxp.mapper;

import com.lsxp.pojo.UserGroup;
import com.lsxp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserGroupMapperTest {

    UserGroupMapper userGroupMapper;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSession();
        userGroupMapper = session.getMapper(UserGroupMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void getUserGroup() {
        List<UserGroup> userGroups = userGroupMapper.getUserGroup();
        for (UserGroup userGroup : userGroups) {
            System.out.println(userGroup);
        }
    }

    @Test
    public void getUserGroup2() {
        List<UserGroup> userGroups = userGroupMapper.getUserGroup2();
        for (UserGroup userGroup : userGroups) {
            System.out.println(userGroup);
        }
    }
}