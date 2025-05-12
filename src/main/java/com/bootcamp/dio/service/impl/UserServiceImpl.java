package com.bootcamp.dio.service.impl;

import com.bootcamp.dio.domain.model.User;
import com.bootcamp.dio.domain.repository.UserRepository;
import com.bootcamp.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (repository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Esse numéro da conta já existe.");
        }
        return repository.save(userToCreate);
    }
}
