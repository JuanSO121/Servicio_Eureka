package com.co.sanchez.usuario.service;


import com.co.sanchez.usuario.models.entity.Alumno;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public interface AlumnoService {
    public Iterable<Alumno> findAll () ;
    public Optional<Alumno> findById (Long id);
    public Alumno save(Alumno alumno) ;
    public void deleteById(Long id) ;
}
