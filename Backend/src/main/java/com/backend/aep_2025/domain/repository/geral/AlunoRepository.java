package com.backend.aep_2025.domain.repository.geral;

import com.backend.aep_2025.domain.entity.geral.Aluno;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.repository.GenericRepository;

public interface AlunoRepository extends GenericRepository<Aluno> {
    Aluno findAlunoByCadastro(Cadastro cadastro);
}
