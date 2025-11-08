package com.backend.aep_2025.domain.entity.form;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modeloresposta", schema = "aep_principal")
@Data
@NoArgsConstructor
public class ModeloResposta implements GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_modeloresposta_id")
    @SequenceGenerator(name = "seq_modeloresposta_id", sequenceName = "seq_modeloresposta_id", allocationSize = 1, schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    private boolean correta;

}
