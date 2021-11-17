package com.project.spring_project.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.project.spring_project.entities.User;
import com.project.spring_project.repositories.UserRepository;
import com.project.spring_project.services.exceptions.DatabaseException;
import com.project.spring_project.services.exceptions.ResourseNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

        return obj.orElseThrow(() -> new ResourseNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourseNotFoundException(id);
        }
    }

    private void updateDate(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
