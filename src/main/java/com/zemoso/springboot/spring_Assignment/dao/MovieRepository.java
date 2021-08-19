package com.zemoso.springboot.spring_Assignment.dao;

import com.zemoso.springboot.spring_Assignment.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
