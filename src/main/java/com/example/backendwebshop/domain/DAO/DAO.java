package com.example.backendwebshop.domain.DAO;

import com.example.backendwebshop.domain.exception.ResourceNotFoundException;

import java.util.List;

public interface DAO<T> {

    T getById(String id) throws ResourceNotFoundException;
    T saveToDatabase(T t);
    T update(String id, T t) throws ResourceNotFoundException;
    void delete(String id) throws ResourceNotFoundException;
    List<T> getAll();
}