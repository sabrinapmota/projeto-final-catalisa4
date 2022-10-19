package com.api.doacaopontos.model;

import com.api.doacaopontos.model.enuns.CategoriaItemEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recolha")
public class RecolhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length =  100)
    private String nomeItem;

    @Column(nullable = false, length = 15)
    private Long pontos;

    @Enumerated(EnumType.STRING)
    private CategoriaItemEnum categoriaItem;



}
