package com.project.spring_project.services;

import java.util.List;
import java.util.Optional;

import com.project.spring_project.entities.User;
import com.project.spring_project.repositories.UserRepository;

import org.hibernate.loader.plan.spi.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);

        return obj.get();
    }

    public User insert(User obj) {
       return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public User update(Long id, User obj) {
        User entity = repository.getById(id);
        updateDate(entity, obj);
        return repository.save(entity);
    }

    private void updateDate(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
