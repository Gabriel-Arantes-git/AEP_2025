package com.backend.aep_2025.domain.entity.login;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "aep_login",name = "tipo_usuario")
public class TipoUsuario implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_tipo_usuario_id")
    @SequenceGenerator(name = "seq_tipo_usuario_id",sequenceName = "seq_tipo_usuario_id",allocationSize = 1,schema = "aep_login")
    @Column(name = "idkey")
    private Integer id;

    private String descricao;
}
