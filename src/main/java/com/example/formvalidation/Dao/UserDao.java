package com.example.formvalidation.Dao;

import com.example.formvalidation.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserDao extends CrudRepository<User, Long> {
    @Override
    Iterable<User> findAll();

    Optional<User> findById(Long id);
    User findByEmail(String email);

    @Query("select s from User s where email= :email and password = :password")
    public User login(String email, String password);
}
