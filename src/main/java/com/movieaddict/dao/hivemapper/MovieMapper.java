package com.movieaddict.dao.hivemapper;

import com.movieaddict.pojo.Movie;

import java.util.List;

/**
 * #Author :Sino
 * #Date   :2022/5/15 10:54
 * #Describe:
 */
public interface MovieMapper {
    /**
     * 测试pojo查询
     * @return pojo列表
     */
    List<Movie> testSelect();

    /**
     * 测试HQL DML
     * @return 总记录数
     */
    Integer getCount();

    /**
     * Demand 1:
     *  Find the average rating of the movies released each year
     *  between 2002 to 20011 and display the result on the web
     *  page by using a graph.
     * @return pojo列表
     */
    List<Movie> getAverageRating();

    /**
     * Demand 2:
     *  Find the lowest 10 movies based on the rating, which
     *  have column movie_duration_second as an odd number.
     * @return pojo列表
     */
    List<Movie> getLowestTenRating();

    /**
     * Demand 3:
     *  Find the 10 values of year_of_release column in which
     *  the total sum of movie_duration_second column is the
     *  highest.
     * @return pojo列表
     */
    List<Movie> getHighestDuration();

    /**
     * Demand 4:
     *  Find the list of the movies that have rating greater
     *  than 3 or movie_duration_second is less than 4000.
     * @return pojo列表
     */
    List<Movie> getRequiredDurationAndRating();

    /**
     * Demand 5:
     *  Find the year_of_release and rating of lowest 3
     *  movies based on rating.
     * @return pojo列表
     */
    List<Movie> getLowestRatingYear();

    /**
     * Demand 6:
     *  Find the year_of_release and rating of lowest 3 movies
     *  based on movie_duration_second. And movies should be
     *  released between 2005 to 2012.
     * @return pojo列表
     */
    List<Movie> getRequired();
}
