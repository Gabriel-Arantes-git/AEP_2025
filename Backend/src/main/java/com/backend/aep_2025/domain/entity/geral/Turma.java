package com.backend.aep_2025.domain.entity.geral;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "turma",schema = "aep_principal")
public class Turma implements GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_turma_id")
    @SequenceGenerator(name = "seq_turma_id",sequenceName = "seq_turma_id",allocationSize = 1,schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    private String serie;

    @ManyToOne
    @JoinColumn(name = "nivel_ensino", referencedColumnName = "idkey")
    private NivelEnsino nivelEnsino;

}
