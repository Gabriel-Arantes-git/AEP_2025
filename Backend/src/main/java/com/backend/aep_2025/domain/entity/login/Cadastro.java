package com.backend.aep_2025.domain.entity.login;

import com.backend.aep_2025.domain.entity.GenericEntity;
import com.backend.aep_2025.domain.entity.geral.Turma;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "aep_login",name = "cadastro")
@Data
public class Cadastro implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cadastro_id")
    @SequenceGenerator(name = "seq_cadastro_id",sequenceName = "seq_cadastro_id",allocationSize = 1,schema = "aep_login")
    @Column(name = "idkey")
    private Integer id;

    private String username;
    @Column(name = "senha")
    private String password;
    private String cpf;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idkey_tipo_usuario", referencedColumnName = "idkey")
    private TipoUsuario tipoUsuario;



}
