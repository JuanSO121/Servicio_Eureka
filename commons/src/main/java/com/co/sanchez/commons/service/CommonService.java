package com.co.sanchez.commons.service;


import java.util.Optional;

//@Service
public interface CommonService <E> {
    public Iterable<E> findAll () ;
    public Optional<E> findById (Long id);
    public E save(E entity) ;
    public void deleteById (Long id) ;
}
