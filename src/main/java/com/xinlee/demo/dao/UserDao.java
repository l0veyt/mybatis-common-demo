package com.xinlee.demo.dao;

import com.xinlee.demo.pojo.User;

import java.util.List;

/**
 * Created by xin.lee on 2017/2/22.
 * 用户持久层接口
 */
public interface UserDao {

    User selectUserById(Integer id);

    List<User> selectUserByName(String username);

    int insertUser(User user);
}
