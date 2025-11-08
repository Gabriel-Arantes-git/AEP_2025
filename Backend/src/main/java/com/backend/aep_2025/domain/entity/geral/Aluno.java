package com.backend.aep_2025.domain.entity.geral;

import com.backend.aep_2025.domain.entity.GenericEntity;
import com.backend.aep_2025.domain.entity.form.Questionario;
import com.backend.aep_2025.domain.entity.login.Cadastro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "alunos", schema = "aep_principal")
@Data
@NoArgsConstructor
public class Aluno implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_alunos_id")
    @SequenceGenerator(name = "seq_alunos_id",sequenceName = "seq_alunos_id",allocationSize = 1,schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    @Column(name = "nome_completo")
    private String nome;

    @OneToOne
    @JoinColumn(name = "idkey_cadastro", referencedColumnName = "idkey")
    private Cadastro cadastro;

    @ManyToOne
    @JoinColumn(name = "idkey_turma", referencedColumnName = "idkey")
    private Turma turma;


}
