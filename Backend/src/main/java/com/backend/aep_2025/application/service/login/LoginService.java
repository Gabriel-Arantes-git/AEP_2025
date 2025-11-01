package com.backend.aep_2025.application.service.login;

import com.backend.aep_2025.api.dto.CadastroDTO;
import com.backend.aep_2025.api.dto.LoginDTO;
import com.backend.aep_2025.api.mapper.CadastroMapper;
import com.backend.aep_2025.application.exception.globalError.GenericException;
import com.backend.aep_2025.application.exception.globalError.InvalidArgumentException;
import com.backend.aep_2025.application.service.geral.ProfessorService;
import com.backend.aep_2025.application.utils.ValidationUtils;
import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.enums.TipoCadastro;
import com.backend.aep_2025.domain.repository.login.CadastroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class LoginService extends GenericService<Cadastro, CadastroRepository> {
    private final CadastroRepository cadastroRepository;
    private final CadastroMapper cadastroMapper;
    private final ProfessorService professorService;

    @Override
    public CadastroRepository getRepository() {
        return cadastroRepository;
    }

    public Cadastro login(LoginDTO loginDTO){
        Cadastro cadastro = cadastroRepository.getByEmail(loginDTO.email())
                .orElseThrow(()-> new InvalidArgumentException(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos"));
        if(!cadastro.getPassword().equals(loginDTO.password())){
            throw new InvalidArgumentException(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos");
        }
        return cadastro;
    }

    public Cadastro registrar(CadastroDTO registro) throws GenericException {
        ValidationUtils.requireValidEmail(registro.email());
        if(cadastroRepository.existsByEmail(registro.email())){
            throw new InvalidArgumentException(registro.email(),"Email já existe");
        }

        Cadastro cadastro = super.save(cadastroMapper.toEntity(registro));
        if(registro.tipoCadastro().equals(TipoCadastro.PROFESSOR)){
            professorService.save(cadastroMapper.toProfessor(registro,cadastro));
        }else if(registro.tipoCadastro().equals(TipoCadastro.ALUNO)){
            //é aqui q vai ficar o do aluno
        }

        return cadastro;
    }
}
