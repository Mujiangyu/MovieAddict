package com.movieaddict.pojo;

/**
 * #Author :Sino
 * #Date   :2022/5/15 10:51
 * #Describe:
 */
public class Movie {
    private Integer id;
    private String movieName;
    private Integer yearOfRelease;
    private Double rating;
    private Integer movieDurationSecond;

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", rating=" + rating +
                ", movieDurationSecond=" + movieDurationSecond +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getMovieDurationSecond() {
        return movieDurationSecond;
    }

    public void setMovieDurationSecond(Integer movieDurationSecond) {
        this.movieDurationSecond = movieDurationSecond;
    }
}
