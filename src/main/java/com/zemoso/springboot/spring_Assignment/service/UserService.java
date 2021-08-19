package com.zemoso.springboot.spring_Assignment.service;

import com.zemoso.springboot.spring_Assignment.dto.UserRegistrationDto;
import com.zemoso.springboot.spring_Assignment.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
