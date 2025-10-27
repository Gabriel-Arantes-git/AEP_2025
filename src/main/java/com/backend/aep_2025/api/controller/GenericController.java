package com.backend.aep_2025.api.controller;

import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.GenericEntity;
import com.backend.aep_2025.domain.repository.GenericRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface GenericController<T extends GenericEntity, R extends GenericRepository<T>, S extends GenericService<T, R>> {
    S getService();

    @GetMapping
    default ResponseEntity<List<T>> findAll(){
        return  ResponseEntity.ok(getService().findAll());
    }

    @GetMapping("/{id}")
    default ResponseEntity<T> getById(@PathVariable Integer id){
        return  getService().findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<Void> deleteById(@PathVariable Integer id){
        return getService().delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
