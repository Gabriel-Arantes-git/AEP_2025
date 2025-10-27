package com.backend.aep_2025.application.service;

import com.backend.aep_2025.domain.entity.GenericEntity;
import com.backend.aep_2025.domain.repository.GenericRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<T extends GenericEntity,
        R extends GenericRepository<T>> {

    public abstract R getRepository();

    @Transactional(readOnly = true)
    public Optional<T> findById(Integer id){
        if (id == null) {
            return Optional.empty();
        }
        return getRepository().findById(id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll(){
        return getRepository().findAll();
    }

    @Transactional
    public T save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entidade não pode ser nula");
        }
        return getRepository().save(entity);
    }
    @Transactional
    public Optional<T> update(Integer id, T entity) {
        if (id == null || entity == null) {
            return Optional.empty();
        }

        return findById(id).map(existingEntity -> {
            entity.setId(id);
            return save(entity);
        });
    }

    @Transactional
    public boolean delete(Integer id) {
        if (id == null) {
            return false;
        }

        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

}
