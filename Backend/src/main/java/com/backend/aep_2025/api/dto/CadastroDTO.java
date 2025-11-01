package com.backend.aep_2025.api.dto;

import com.backend.aep_2025.domain.entity.geral.Turma;
import com.backend.aep_2025.domain.enums.TipoCadastro;

public record CadastroDTO (
        String email,
        String password,
        String username,
        String cpf,
        TipoCadastro tipoCadastro,
        Turma turma
){
}
