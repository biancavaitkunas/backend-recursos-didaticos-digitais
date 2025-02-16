package com.example.rdd.Controller.Generic;

import com.example.rdd.Service.Generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T, ID> {

    @Autowired
    private GenericService<T, ID> genericService;

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T createdEntity = genericService.save(entity);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        return ResponseEntity.ok(genericService.update(id, entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        return ResponseEntity.of(genericService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(genericService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        genericService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
