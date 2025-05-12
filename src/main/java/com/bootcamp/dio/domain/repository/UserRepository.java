package com.bootcamp.dio.domain.repository;

import com.bootcamp.dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
