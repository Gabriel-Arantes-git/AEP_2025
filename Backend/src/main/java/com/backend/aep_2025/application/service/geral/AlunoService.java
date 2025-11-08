package com.backend.aep_2025.application.service.geral;

import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.geral.Aluno;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.repository.geral.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService extends GenericService<Aluno, AlunoRepository> {

    private final AlunoRepository alunoRepository;
    @Override
    public AlunoRepository getRepository() {
        return alunoRepository;
    }

    public Aluno findByCadastro(Cadastro cadastro) {
        return alunoRepository.findAlunoByCadastro(cadastro);
    }
}
