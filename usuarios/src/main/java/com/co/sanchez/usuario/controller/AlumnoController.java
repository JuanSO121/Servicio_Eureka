package com.co.sanchez.usuario.controller;

import com.co.sanchez.usuario.models.entity.Alumno;
import com.co.sanchez.usuario.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService service;

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @Autowired
    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Alumno>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

//    @GetMapping("/balanceador-test")
//    public ResponseEntity<?> balanceadorTest() {
//        Map<String, Object> response = new HashMap<String, Object> ();
//        response.put("balanceador", balanceadorTest);
//        response.put("alumno", service.findAll());
//
//        return ResponseEntity.ok().body(response);
//    }

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("balanceador", balanceadorTest); // Variable de entorno
            response.put("alumno", service.findAll()); // Lista de alumnos
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Error al obtener los datos de alumnos");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Long id) {
        Optional<Alumno> alumno = service.findById(id);
        return alumno.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        Alumno savedAlumno = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAlumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Alumno> existingAlumno = service.findById(id);
        if (existingAlumno.isPresent()) {
            Alumno updatedAlumno = existingAlumno.get();
            updatedAlumno.setNombre(alumno.getNombre());
            updatedAlumno.setApellido(alumno.getApellido());
            updatedAlumno.setEmail(alumno.getEmail());
            service.save(updatedAlumno);
            return ResponseEntity.ok(updatedAlumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
