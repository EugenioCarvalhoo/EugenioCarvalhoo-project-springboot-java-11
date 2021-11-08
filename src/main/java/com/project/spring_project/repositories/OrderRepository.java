package com.project.spring_project.repositories;

import com.project.spring_project.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
    
}
