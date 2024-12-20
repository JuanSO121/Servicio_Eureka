package com.co.sanchez.commons.controller;

import com.co.sanchez.commons.service.CommonService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class CommonController<E, S extends CommonService<E>> {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CommonController.class);


    @Autowired
    protected S service;

    @Value("${config.balanceador.test}")
    protected String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest(){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("entity", service.findAll());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Iterable<E>> getAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getById(@PathVariable Long id) {
        Optional<E> entity  = service.findById(id);
        return entity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity) {
        E savedEntity= service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
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