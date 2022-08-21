package com.example.realWorld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.realWorld.domain.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
