package com.api.doacaopontos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
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

    public ItemDoado(Long id, String nome, String descricao, Long idPessoaDoadora, String status, LocalDate dataInicio, LocalDate dataTermino, Long idPessoaRecebedora, Long pontosDoador, Long pontosRecebedor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idPessoaDoadora = idPessoaDoadora;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idPessoaRecebedora = idPessoaRecebedora;
        this.pontosDoador = pontosDoador;
        this.pontosRecebedor = pontosRecebedor;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioModel usuarioModel;
}
