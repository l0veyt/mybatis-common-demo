package com.xinlee.demo;

import com.xinlee.demo.dao.UserDao;
import com.xinlee.demo.dao.impl.UserDaoImpl;
import com.xinlee.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by xin.lee on 2017/2/22.
 * mybatis传统方式开发DAO 测试类
 */
public class CommonTest {

    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDao = new UserDaoImpl(sessionFactory);
    }

    @Test
    public void selectUserById() {
        User user = userDao.selectUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectUserByName() {
        List<User> list = userDao.selectUserByName("%李%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("王五");
        user.setBirthday(new Date());
        int count = userDao.insertUser(user);
        System.out.println(count);
    }
}
