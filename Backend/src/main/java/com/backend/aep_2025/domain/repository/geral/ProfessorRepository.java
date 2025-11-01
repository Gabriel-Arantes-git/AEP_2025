package com.backend.aep_2025.domain.repository.geral;

import com.backend.aep_2025.domain.entity.geral.Professor;
import com.backend.aep_2025.domain.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends GenericRepository<Professor> {
    Optional<Professor> findByCadastro_Id(long cadastro_id);
}
