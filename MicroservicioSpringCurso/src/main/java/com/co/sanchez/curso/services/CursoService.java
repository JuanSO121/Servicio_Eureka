package com.co.sanchez.curso.services;

import com.co.sanchez.commons.service.CommonService;
import com.co.sanchez.curso.models.entity.Curso;
import com.co.sanchez.curso.repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends CommonService<Curso>{

    @Autowired
    private CursoRepository dao;

    public CursoService(CrudRepository<Curso, Long> dao) {
        super(dao);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return dao.save(curso);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}