package com.co.sanchez.usuario.controller;

import java.util.Optional;
import java.util.List;

import com.co.sanchez.common.usuario.models.entity.Alumno;
import com.co.sanchez.commons.controller.CommonController;
import com.co.sanchez.usuario.service.AlumnoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Alumno> existingAlumno = service.findById(id);
        if (existingAlumno.isPresent()) {
            Alumno alumnoBd = existingAlumno.get();
            alumnoBd.setNombre(alumno.getNombre());
            alumnoBd.setApellido(alumno.getApellido());
            alumnoBd.setEmail(alumno.getEmail());
            service.save(alumnoBd);
            return ResponseEntity.ok(alumnoBd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}