package com.movieaddict;

import com.movieaddict.dao.hivemapper.MovieMapper;
import com.movieaddict.pojo.Movie;
import com.movieaddict.utils.DataSourceContextHolder;
import com.movieaddict.utils.DataSourceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Author :Sino
 * #Date   :2022/5/15 10:31
 * #Describe:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestHiveJdbc {
    @Autowired
    private MovieMapper mapper;
    @Test
    public void testSelectPart() {
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> movies = mapper.testSelect();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    @Test
    public void testGetCount() {
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        System.out.println(mapper.getCount());
    }
}
