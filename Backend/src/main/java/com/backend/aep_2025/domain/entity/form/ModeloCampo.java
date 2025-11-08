package com.backend.aep_2025.domain.entity.form;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelocampo", schema = "aep_principal")
@Data
@NoArgsConstructor
public class ModeloCampo implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_modelocampo_id")
    @SequenceGenerator(name = "seq_modelocampo_id", sequenceName = "seq_modelocampo_id", allocationSize = 1, schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    private String pergunta;
}
