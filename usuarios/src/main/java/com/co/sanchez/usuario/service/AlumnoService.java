package com.co.sanchez.usuario.service;


import com.co.sanchez.common.usuario.models.entity.Alumno;
import com.co.sanchez.commons.service.CommonService;
import com.co.sanchez.common.usuario.models.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.co.sanchez.usuario.repository.AlumnoRepository;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class AlumnoService extends CommonService<Alumno> {

    public AlumnoService(CrudRepository<Alumno, Long> dao) {
        super(dao);
    }

    @Autowired
    private AlumnoRepository dao;

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return dao.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}