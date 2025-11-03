package com.backend.aep_2025.api.controller.login;

import com.backend.aep_2025.api.controller.GenericController;
import com.backend.aep_2025.api.dto.CadastroDTO;
import com.backend.aep_2025.api.dto.LoginDTO;
import com.backend.aep_2025.application.service.GenericService;
import com.backend.aep_2025.application.service.login.LoginService;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import com.backend.aep_2025.domain.repository.GenericRepository;
import com.backend.aep_2025.domain.repository.login.CadastroRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController implements GenericController<Cadastro, CadastroRepository, LoginService> {
    private LoginService loginService;

    @Override
    public LoginService getService() {
        return loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Cadastro> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(loginService.login(loginDTO));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Cadastro> registrar(@RequestBody CadastroDTO cadastroDTO){
        return ResponseEntity.ok(loginService.registrar(cadastroDTO));
    }

}
