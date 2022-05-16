package com.movieaddict;

import com.movieaddict.dao.mysqlmapper.UserMapper;
import com.movieaddict.pojo.User;
import com.movieaddict.utils.DataSourceContextHolder;
import com.movieaddict.utils.DataSourceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * #Author :Sino
 * #Date   :2022/5/15 9:59
 * #Describe:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMysqlJdbc {
    @Autowired
    private UserMapper mapper;
    @Test
    public void testInsert() {
        // change the datasource
        DataSourceContextHolder.setDbType(DataSourceType.MYSQL_SOURCE);
        mapper.insert(new User(null, "root", "123123", "root@gmail.com"));
    }
}
