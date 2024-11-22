package com.co.sanchez.usuario.service;
import com.co.sanchez.commons.service.CommonServiceImpl;
import com.co.sanchez.common.usuario.models.entity.Alumno;

public interface AlumnoServiceImpl extends CommonServiceImpl<Alumno> {
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
}