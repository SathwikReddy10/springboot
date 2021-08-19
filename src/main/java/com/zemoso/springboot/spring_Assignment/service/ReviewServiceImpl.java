package com.zemoso.springboot.spring_Assignment.service;

import com.zemoso.springboot.spring_Assignment.dao.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void deleteById(int theId) throws RuntimeException{
        reviewRepository.deleteById(theId);
    }
}
