package com.backend.aep_2025.api.dto;

import com.backend.aep_2025.domain.entity.geral.Turma;
import com.backend.aep_2025.domain.entity.login.TipoUsuario;

public record ResponseCadastroDTO(
        String email,
        String password,
        String username,
        String cpf,
        TipoUsuario tipoUsuario,
        Turma turma
) {
}
