package com.xinlee.demo.dao.impl;

import com.xinlee.demo.dao.UserDao;
import com.xinlee.demo.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by xin.lee on 2017/2/22.
 * 用户持久层实现类
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User selectUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.selectUserById", id);
        sqlSession.close();
        return user;
    }

    public List<User> selectUserByName(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.selectUserByName", username);
        sqlSession.close();
        return userList;
    }

    public int insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int count = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
