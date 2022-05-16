package com.movieaddict.service;

import com.movieaddict.dao.mysqlmapper.UserMapper;
import com.movieaddict.pojo.User;
import com.movieaddict.pojo.UserExample;
import com.movieaddict.utils.DataSourceContextHolder;
import com.movieaddict.utils.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #Author :Sino
 * #Date   :2022/5/15 12:33
 * #Describe:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public boolean userLogin(User user) {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.MYSQL_SOURCE);
        UserExample example = new UserExample();
        String userName = user.getUserName();
        String password = user.getPassword();
        example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        final List<User> users = mapper.selectByExample(example);
        return users.size() != 0;
    }

    public void userRegister(User user) {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.MYSQL_SOURCE);
        mapper.insertSelective(user);
    }

    public boolean userNameCheck(User user) {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.MYSQL_SOURCE);
        String userName = user.getUserName();
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        final List<User> users = mapper.selectByExample(example);
        return users.size() == 0;
    }
}
