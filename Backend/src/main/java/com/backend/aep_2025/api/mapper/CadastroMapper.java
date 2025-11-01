package com.backend.aep_2025.api.mapper;

import com.backend.aep_2025.api.dto.CadastroDTO;
import com.backend.aep_2025.application.exception.globalError.InvalidArgumentException;
import com.backend.aep_2025.domain.entity.geral.Professor;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.entity.login.TipoUsuario;
import com.backend.aep_2025.domain.repository.login.CadastroRepository;
import com.backend.aep_2025.domain.repository.login.TipoUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CadastroMapper {
    private final CadastroRepository cadastroRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public Cadastro toEntity(CadastroDTO dto) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findByDescricao(dto.tipoCadastro().name())
                .orElseThrow(()-> new InvalidArgumentException(dto.tipoCadastro(),"tipo cadastro inválido"));

        Cadastro novoCadastro = new Cadastro();
        novoCadastro.setTipoUsuario(tipoUsuario);
        novoCadastro.setEmail(dto.email());
        novoCadastro.setPassword(dto.password());
        novoCadastro.setCpf(dto.cpf());
        novoCadastro.setUsername(dto.username());

        return novoCadastro;
    }

    public Professor toProfessor(CadastroDTO dto,Cadastro cadastro) {
        Professor professor = new Professor();
        professor.setNome(dto.username());
        professor.setCadastro(cadastro);
        return professor;
    }
}
