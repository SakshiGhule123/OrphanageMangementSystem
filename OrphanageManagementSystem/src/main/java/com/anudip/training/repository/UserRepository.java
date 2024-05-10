package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.anudip.training.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameIgnoreCase(String username);

}

