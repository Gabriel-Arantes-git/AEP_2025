package com.backend.aep_2025.application.service.geral;

import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.geral.Turma;
import com.backend.aep_2025.domain.repository.geral.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TurmaService extends GenericService<Turma, TurmaRepository> {
    private final TurmaRepository turmaRepository;
    @Override
    public TurmaRepository getRepository() {
        return turmaRepository;
    }
}
