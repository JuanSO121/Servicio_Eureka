package com.co.sanchez.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CommonServiceImpl <E>{
    public Iterable<E> findAll();
    public Optional<E> findById(Long id);
    public E save(E entity);
    public void deleteById(Long id);
}
