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
 * #Date   :2022/5/16 17:47
 * #Describe:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemands {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void testGetAverageRating() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> averageRating = movieMapper.getAverageRating();
        for (Movie movie : averageRating) {
            System.out.println(movie);
        }
    }

    @Test
    public void testGetLowestTenRating() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> lowestTenRating = movieMapper.getLowestTenRating();
        for (Movie movie : lowestTenRating) {
            System.out.println(movie);
        }
    }

    @Test
    public void testGetHighestDuration() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> highestDuration = movieMapper.getHighestDuration();
        for (Movie movie : highestDuration) {
            System.out.println(movie);
        }
    }

    @Test
    public void testGetRequiredDurationAndRating() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> requiredDurationAndRating = movieMapper.getRequiredDurationAndRating();
        for (Movie movie : requiredDurationAndRating) {
            System.out.println(movie);
        }
    }

    @Test
    public void testGetLowestRatingYear() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> lowestTenRating = movieMapper.getLowestTenRating();
        for (Movie movie : lowestTenRating) {
            System.out.println(movie);
        }
    }

    @Test
    public void testGetRequired() {
        DataSourceContextHolder.clearDbType();
        DataSourceContextHolder.setDbType(DataSourceType.HIVE_SOURCE);
        final List<Movie> required = movieMapper.getRequired();
        for (Movie movie : required) {
            System.out.println(movie);
        }
    }
}
