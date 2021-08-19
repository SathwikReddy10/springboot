package com.zemoso.springboot.spring_Assignment.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter @Setter @NoArgsConstructor @ToString
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    private String language;

    private String actor;

    private String director;

    private String genres;

    @Min(value = 0)
    @Max(value = 10)
    private float rating;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="movie_id")
    private List<Review> reviews;

    public Movie(String name, String language, String actor, String director, String genres, float rating) {
        this.name = name;
        this.language = language;
        this.actor = actor;
        this.director = director;
        this.genres = genres;
        this.rating = rating;
    }

    public void addReview(Review theReview) {
        if(reviews==null)
            reviews = new ArrayList<>();
        reviews.add(theReview);
    }


}
