package com.lsxp.mapper;

import com.lsxp.pojo.User;
import com.lsxp.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.List;


public class UserMapperTest {

    UserMapper userMapper = null;
    SqlSession session = null;

    @Before
    public void setUp() throws Exception {
        session = MyBatisUtil.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        /*session.close();*/
    }


    /*
    * 一级缓存测试
    * SqlSession级别
    * */
    @Test
    public void cacheTestLv1(){
        int id =1;
        System.out.println("==========================这里是第一次查询=====================================");
        User user = session.selectOne("com.lsxp.mapper.UserMapper.findUserById",id);
        System.out.println(user.toString());
        System.out.println("==========================这里是第二次查询=====================================");
        User user1 = session.selectOne("com.lsxp.mapper.UserMapper.findUserById",id);
        System.out.println(user1.toString());
        System.out.println("==========================执行更新语句=====================================");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("zyy");
        session.update("com.lsxp.mapper.UserMapper.updateUser",user2);
        System.out.println("==========================这是第三次查询=====================================");
        User user3 = session.selectOne("com.lsxp.mapper.UserMapper.findUserById",id);
        System.out.println(user3.toString());
    }


    /*
    * 二级缓存测试
    * Mapper级别
    * */
    @Test
    public void cacheTestLv2(){
        /* 在setUp()函数中已经提前建立好了一个SqlSession的实例，名为session，并创建了对应代理对象，名为userMapper */
        /* 因此为了验证二级缓存，仅再创建两个SqlSession的实例即可 */
        SqlSession session2 = MyBatisUtil.getSession();
        SqlSession session3 = MyBatisUtil.getSession();
        UserMapper userMapper2 = session2.getMapper(UserMapper.class);
        UserMapper userMapper3 = session3.getMapper(UserMapper.class);

        int id = 2;

        System.out.println("***这是mapper级别的缓存测试***");
        System.out.println("***这是第一次使用“session”调用查询语句***");
        User user = userMapper.findUserById(id);
        System.out.println(user.toString());
        /* 注意：在MyBatis的缓存策略是在SqlSession释放内存时写入内存，因此在此处需要调用close() */
        session.close();

        System.out.println("***这是第二次使用“session2”调用查询语句***");
        User user2 = userMapper2.findUserById(id);
        System.out.println(user2.toString());

        System.out.println("***使用“session2”调用更新语句***");
        User user3 = new User();
        user3.setId(3);
        user3.setUsername("lxy");
        System.out.println(user3);
        userMapper2.updateUser(user3);
        session2.commit();
        session2.close();

        System.out.println("***这是第三次使用“session3”调用查询语句***");
        User user4 = userMapper3.findUserById(id);
        System.out.println(user4.toString());
        session3.close();
    }

    @Test
    public void queryAll() {
        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("==========================这里是第二次查询=====================================");
        List<User> users1 = userMapper.queryAll();
        for (User user : users1) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserAndProfileById() {
        User user = userMapper.queryUserAndProfileById(2);
        System.out.println(user);
    }

    @Test
    public void queryUserAndProfileByIdResult() {
        User user = userMapper.queryUserAndProfileByIdResult(1);
        System.out.println(user);
    }



}