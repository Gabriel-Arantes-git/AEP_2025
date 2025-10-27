package com.backend.aep_2025.application.service.login;

import com.backend.aep_2025.api.dto.CadastroDTO;
import com.backend.aep_2025.api.dto.LoginDTO;
import com.backend.aep_2025.api.mapper.CadastroMapper;
import com.backend.aep_2025.application.exception.globalError.InvalidArgumentException;
import com.backend.aep_2025.application.utils.ValidationUtils;
import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.login.Cadastro;
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

    public Cadastro registrar(CadastroDTO registro){
        ValidationUtils.requireValidEmail(registro.email());
        if(cadastroRepository.existsByEmail(registro.email())){
            throw new RuntimeException("Email já existe");
        }
        return cadastroRepository.save(cadastroMapper.toEntity(registro));
    }
}
