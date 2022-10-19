package com.api.doacaopontos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_DOADOR")
public class UsuarioModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    @Email
    private String email;
    @Column(nullable = false, length = 12)
    private String telefone;
    @Column
    private Long pontos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL)
    private List<ItemDoado> itemDoados;
}
