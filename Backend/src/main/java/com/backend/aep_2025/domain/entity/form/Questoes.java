package com.backend.aep_2025.domain.entity.form;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "questoes", schema = "aep_principal")
@Data
@NoArgsConstructor
public class Questoes implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_questoes_id")
    @SequenceGenerator(name = "seq_questoes_id", sequenceName = "seq_questoes_id", allocationSize = 1, schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idkey_modelocampo", referencedColumnName = "idkey")
    private ModeloCampo modeloCampo;
}
