package com.api.doacaopontos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_DOADOR")
public class CadastroDoadorModel implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 30)
    private String nome;
    @CPF
    private String cpf;
    @Email
    private String email;
    @Column(nullable = false, length = 12)
    private String telefone;
    @Column(nullable = false, length = 250)
    private String endereco;
    @Column(nullable = false, length = 40)
    private String bairro;
    @Column(nullable = false, length = 8)
    private String cep;
    private String pontos;
}
