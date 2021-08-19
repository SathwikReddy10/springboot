package com.zemoso.springboot.spring_Assignment.controller;

import com.zemoso.springboot.spring_Assignment.entity.Movie;
import com.zemoso.springboot.spring_Assignment.entity.Review;
import com.zemoso.springboot.spring_Assignment.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    public String listMovies(Model theModel)
    {
        List<Movie> theMovies = movieService.findAll();
        theModel.addAttribute("movies", theMovies);
        return "movies/list-movies";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Movie theMovie = new Movie();
        theModel.addAttribute("movie", theMovie);
        return "movies/movie-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("movieId") int theId, Model theModel)
    {
        Movie theMovie = movieService.findById(theId);
        theModel.addAttribute("movie", theMovie);
        return "movies/movie-form";
    }

    @PostMapping("/save")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie theMovie, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
            return "movies/movie-form";
        movieService.save(theMovie);
        return "redirect:/movies/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("movieId") int theId)
    {
        movieService.deleteById(theId);
        return "redirect:/movies/list";
    }
    @GetMapping("/reviews")
    public String reviews(@RequestParam("movieId") int theId,
                          Model theModel) {
        Review theReview = new Review(0,theId);
        List<Review> reviews = movieService.findAllReviews(theId);
        theModel.addAttribute("review", theReview);
        theModel.addAttribute("reviews", reviews);
        return "/movies/list-reviews";
    }

    @PostMapping("/addReview")
    public String addReview(@ModelAttribute("reviews") Review theReview) {
        movieService.addReview(theReview);
        //return "redirect:/movies/reviews?id="+theReview.getMovie_id();
        return "redirect:/movies/list";
    }
    


}
