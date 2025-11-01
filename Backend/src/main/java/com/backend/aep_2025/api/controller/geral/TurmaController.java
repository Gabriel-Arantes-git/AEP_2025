package com.backend.aep_2025.api.controller.geral;

import com.backend.aep_2025.api.controller.GenericController;
import com.backend.aep_2025.application.service.geral.TurmaService;
import com.backend.aep_2025.domain.entity.geral.Turma;
import com.backend.aep_2025.domain.repository.geral.TurmaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
@AllArgsConstructor
public class TurmaController implements GenericController<Turma,TurmaRepository, TurmaService> {
    private final TurmaService turmaService;

    @Override
    public TurmaService getService() {
        return turmaService;
    }

}
