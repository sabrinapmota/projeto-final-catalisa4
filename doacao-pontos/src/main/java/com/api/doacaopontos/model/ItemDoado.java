package com.api.doacaopontos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table
public class ItemDoado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;
    @Column
    private LocalDate dataDoacao;
    @Column
    @NotNull
    private String estetica;
    @Column
    @NotNull
    private String estrutura;
    @Column
    @NotNull
    private String funcional;
    @Column
    @NotNull
    private String categoria;
    @Column
    @NotNull
    private Long totalPontos;
}
