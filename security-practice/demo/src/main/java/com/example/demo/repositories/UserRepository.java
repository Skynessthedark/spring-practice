package com.example.demo.repositories;

import java.util.Optional;

import com.example.demo.models.UserDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long>{

    Optional<UserDO> findByUsername(String username);
}
