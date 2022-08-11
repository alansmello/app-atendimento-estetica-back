package com.estetica.atendimento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estetica.atendimento.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
