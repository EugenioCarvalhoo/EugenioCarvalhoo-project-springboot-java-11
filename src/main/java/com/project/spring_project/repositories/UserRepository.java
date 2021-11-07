package com.project.spring_project.repositories;

import com.project.spring_project.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
