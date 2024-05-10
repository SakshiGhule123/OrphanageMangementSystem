package com.anudip.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anudip.training.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer>{

    public Login findByUserNameAndPassword(String userName, String password);
}
