package com.zemoso.springboot.spring_Assignment.dao;

import com.zemoso.springboot.spring_Assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}