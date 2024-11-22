package com.co.sanchez.curso.repository;

import org.springframework.data.repository.CrudRepository;
import com.co.sanchez.curso.models.entity.Curso;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

}
