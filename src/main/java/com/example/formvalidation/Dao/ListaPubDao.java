package com.example.formvalidation.Dao;

import com.example.formvalidation.model.ListaPub;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListaPubDao extends CrudRepository<ListaPub, Integer> {
    ListaPub findById(int id);

    List<ListaPub> findByUserId(Long id);
}
