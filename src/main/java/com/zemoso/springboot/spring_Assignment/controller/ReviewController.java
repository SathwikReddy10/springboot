package com.zemoso.springboot.spring_Assignment.controller;

import com.zemoso.springboot.spring_Assignment.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/deletereview")
    public String deletereview(@RequestParam("reviewId") int theId)
    {
        reviewService.deleteById(theId);
        return "redirect:/movies/list";
    }

}
