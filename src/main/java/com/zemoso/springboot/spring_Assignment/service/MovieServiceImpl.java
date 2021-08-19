package com.zemoso.springboot.spring_Assignment.service;

import com.zemoso.springboot.spring_Assignment.dao.MovieRepository;
import com.zemoso.springboot.spring_Assignment.dao.ReviewRepository;
import com.zemoso.springboot.spring_Assignment.entity.Movie;
import com.zemoso.springboot.spring_Assignment.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> findAll() throws RuntimeException {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int theId) throws RuntimeException {
        Optional<Movie> result = movieRepository.findById(theId);
        Movie theMovie = null;
        if(result.isPresent())
            theMovie = result.get();
        else {
            throw new RuntimeException("Movie not found - "+ theId);
        }
        return theMovie;
    }

    @Override
    public void save(Movie theMovie) throws RuntimeException {
        movieRepository.save(theMovie);
    }

    @Override
    public void deleteById(int theId) throws RuntimeException {
        movieRepository.deleteById(theId);
    }

    /*@Override
    public void deleteByReviewId(int theId) throws RuntimeException {
        movieRepository.deleteById(theId);
    }*/

    @Override
    public List<Review> findAllReviews(int theId) throws RuntimeException {
        Movie theMovie = findById(theId);
        List<Review> reviews = theMovie.getReviews();
        return reviews;
    }

    @Override
    public void addReview(Review theReview) throws RuntimeException {
        int theId = theReview.getMovie_id();
        Movie theMovie = findById(theId);
        theMovie.addReview(theReview);
        save(theMovie);

    }
}
