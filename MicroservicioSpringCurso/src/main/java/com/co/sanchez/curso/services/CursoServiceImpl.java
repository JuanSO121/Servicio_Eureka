package com.co.sanchez.curso.services;

import com.co.sanchez.commons.service.CommonServiceImpl;
import com.co.sanchez.curso.models.entity.Curso;



public interface CursoServiceImpl extends CommonServiceImpl<Curso>{
    public Curso save(Curso alumno);
    public void deleteById(Long id);
}