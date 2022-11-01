package com.api.doacaopontos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "doacao")
public class ItemDoado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private String status;
    @Column
    private LocalDate dataInicio;
    @Column
    private LocalDate dataTermino;
    @Column
    private Long pontosDoador;
    @Column
    private Long pontosRecebedor;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel pessoaDoadora;

    @ManyToOne
    @JoinColumn(name = "usuario_recebedor_id", referencedColumnName = "id")
    private UsuarioModel pessoaRecebedora;
}
