package com.self_study.self_study.repository;

import com.self_study.self_study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository()
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
