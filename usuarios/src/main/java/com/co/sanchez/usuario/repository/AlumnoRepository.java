package com.co.sanchez.usuario.repository;

import com.co.sanchez.common.usuario.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
