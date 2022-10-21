package com.api.doacaopontos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String nome;
    @Column
    private String descricao;
    @Column
    private Long idPessoaDoadora;
    @Column
    private String status;
    @Column
    private LocalDate dataInicio;
    @Column
    private LocalDate dataTermino;
    @Column
    private Long idPessoaRecebedora;
    @Column
    private Long pontosDoador;
    @Column
    private Long pontosRecebedor;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuarioModel;
}
