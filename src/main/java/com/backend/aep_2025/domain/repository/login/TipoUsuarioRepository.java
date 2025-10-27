package com.backend.aep_2025.domain.repository.login;

import com.backend.aep_2025.domain.entity.login.TipoUsuario;
import com.backend.aep_2025.domain.repository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoUsuarioRepository extends GenericRepository<TipoUsuario> {
    @Query("SELECT t FROM TipoUsuario t WHERE t.descricao = :desc")
    Optional<TipoUsuario> findByDescricao(@Param("desc") String desc);
}
