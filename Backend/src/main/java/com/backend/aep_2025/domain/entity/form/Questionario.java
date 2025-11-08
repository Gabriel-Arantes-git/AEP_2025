package com.backend.aep_2025.domain.entity.form;

import com.backend.aep_2025.domain.entity.GenericEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "questionarios", schema = "aep_principal")
@Data
@NoArgsConstructor
public class Questionario implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_questionarios_id")
    @SequenceGenerator(name = "seq_questionarios_id", sequenceName = "seq_questionarios_id", allocationSize = 1, schema = "aep_principal")
    @Column(name = "idkey")
    private Integer id;

    @OneToMany
    @JoinColumn(
            name = "idkey_questionario",           // FK na TABELA questoes
            referencedColumnName = "idkey",
            foreignKey = @ForeignKey(name = "fk_idkey_questionario")
    )
    private List<Questoes> questoes;
}
