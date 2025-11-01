package com.backend.aep_2025.domain.entity.geral;

import com.backend.aep_2025.domain.entity.GenericEntity;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "aep_principal",name = "professores")
@Data
@NoArgsConstructor
public class Professor implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_professores_id")
    @SequenceGenerator(name = "seq_professores_id",sequenceName = "seq_professores_id",allocationSize = 1,schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "idkey_cadastro", referencedColumnName = "idkey")
    private Cadastro cadastro;



}
