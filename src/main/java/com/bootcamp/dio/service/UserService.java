package com.bootcamp.dio.service;

import com.bootcamp.dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create (User user);




}
