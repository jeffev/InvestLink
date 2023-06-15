package com.bezkoder.spring.jpa.postgresql.repository;


import com.bezkoder.spring.jpa.postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserNameAndPassword(String userName, String password);
}