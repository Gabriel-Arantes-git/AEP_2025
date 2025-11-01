package com.backend.aep_2025.domain.entity.geral;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "nivel_ensino",schema = "aep_principal")
public class NivelEnsino implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_nivel_ensino_id")
    @SequenceGenerator(name = "seq_nivel_ensino_id",sequenceName = "seq_nivel_ensino_id",allocationSize = 1,schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    private String descricao;
}
