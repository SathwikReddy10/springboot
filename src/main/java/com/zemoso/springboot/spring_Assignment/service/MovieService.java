package com.zemoso.springboot.spring_Assignment.service;

import com.zemoso.springboot.spring_Assignment.entity.Movie;
import com.zemoso.springboot.spring_Assignment.entity.Review;

import java.util.List;

public interface MovieService {

    public List<Movie> findAll();

    public Movie findById(int theId);

    public void save(Movie theMovie);

    public void deleteById(int theId);

    public List<Review> findAllReviews(int theId);

    public void addReview(Review theReview);

}
