package com.backend.aep_2025.application.service.geral;

import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.geral.Professor;
import com.backend.aep_2025.domain.repository.geral.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfessorService extends GenericService<Professor, ProfessorRepository> {

    private final ProfessorRepository professorRepository;
    @Override
    public ProfessorRepository getRepository() {
        return professorRepository;
    }


}
