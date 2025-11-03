package com.backend.aep_2025.domain.repository.login;

import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.repository.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroRepository extends GenericRepository<Cadastro> {

    @Override
    default Class<Cadastro> getEntityClass() {
        return Cadastro.class;
    }


    Optional<Cadastro> findCadastroByEmail(String email);

    @Query(value = "SELECT count(cad) > 0 FROM Cadastro cad WHERE cad.email = :email")
    Boolean existsByEmail(@Param("email") String email);
}
