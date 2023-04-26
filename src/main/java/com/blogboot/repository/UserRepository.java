package com.blogboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
