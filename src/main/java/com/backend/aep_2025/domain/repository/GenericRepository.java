package com.backend.aep_2025.domain.repository;

import com.backend.aep_2025.domain.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity>
    extends JpaRepository<T,Integer>,JpaSpecificationExecutor<T> {

    default Class<T> getEntityClass() {
        throw new UnsupportedOperationException("getEntityClass() deve ser implementado pela classe concreta");
    }

}
