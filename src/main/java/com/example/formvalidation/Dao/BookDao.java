package com.example.formvalidation.Dao;

import com.example.formvalidation.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookDao extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);
    Book findByTitolo(String title);
}
