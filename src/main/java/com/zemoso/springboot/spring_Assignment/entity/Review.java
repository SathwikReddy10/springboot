package com.zemoso.springboot.spring_Assignment.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Getter @Setter @NoArgsConstructor @ToString
@AllArgsConstructor
public class Review {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    private int movie_id;

    private String review;

    public Review(int id) {
        this.id = id;
    }

    public Review(int id, int movie_id) {
        this.id = id;
        this.movie_id = movie_id;
    }
}
