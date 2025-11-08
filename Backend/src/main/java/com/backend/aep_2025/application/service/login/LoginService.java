package com.backend.aep_2025.application.service.login;

import com.backend.aep_2025.api.dto.CadastroDTO;
import com.backend.aep_2025.api.dto.LoginDTO;
import com.backend.aep_2025.api.dto.ResponseCadastroDTO;
import com.backend.aep_2025.api.mapper.CadastroMapper;
import com.backend.aep_2025.application.exception.globalError.GenericException;
import com.backend.aep_2025.application.exception.globalError.InvalidArgumentException;
import com.backend.aep_2025.application.service.geral.AlunoService;
import com.backend.aep_2025.application.service.geral.ProfessorService;
import com.backend.aep_2025.application.utils.ValidationUtils;
import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.domain.entity.geral.Aluno;
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
    private final AlunoService alunoService;

    @Override
    public CadastroRepository getRepository() {
        return cadastroRepository;
    }

    public ResponseCadastroDTO login(LoginDTO loginDTO) throws GenericException{
        System.out.println(loginDTO.email() + " - " + loginDTO.senha());
        Cadastro cadastro = cadastroRepository.findCadastroByEmail(loginDTO.email())
                .orElseThrow(()-> new InvalidArgumentException(HttpStatus.UNAUTHORIZED, "Email incorretos"));
        if(!loginDTO.senha().equals(cadastro.getPassword())){
            throw new InvalidArgumentException(HttpStatus.UNAUTHORIZED, "Email ou senha incorretos");
        }
        if(cadastro.getTipoUsuario().getDescricao().equals("Aluno")){
            Aluno aluno = alunoService.findByCadastro(cadastro);
            return cadastroMapper.toDtoAluno(cadastro,aluno);
        } else if(cadastro.getTipoUsuario().getDescricao().equals("Professor")){
            return cadastroMapper.toDtoProfessor(cadastro);
        }
        else{ throw new RuntimeException();}
    }

    public ResponseCadastroDTO registrar(CadastroDTO registro) throws GenericException {
        ValidationUtils.requireValidEmail(registro.email());
        if(cadastroRepository.existsByEmail(registro.email())){
            throw new InvalidArgumentException(registro.email(),"Email já existe");
        }

        Cadastro cadastro = super.save(cadastroMapper.toEntity(registro));
        if(registro.tipoCadastro().equals(TipoCadastro.PROFESSOR)){
            professorService.save(cadastroMapper.toProfessor(registro,cadastro));
            return cadastroMapper.toDtoProfessor(cadastro);
        }else if(registro.tipoCadastro().equals(TipoCadastro.ALUNO)){
            Aluno aluno = alunoService.save(cadastroMapper.toAluno(registro,cadastro));
            return cadastroMapper.toDtoAluno(cadastro,aluno);
        }else{
            throw new RuntimeException("Erro");
        }

    }
}
