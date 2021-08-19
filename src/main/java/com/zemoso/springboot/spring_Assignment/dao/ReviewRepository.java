package com.zemoso.springboot.spring_Assignment.dao;

import com.zemoso.springboot.spring_Assignment.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
