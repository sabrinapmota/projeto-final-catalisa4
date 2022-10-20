package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoEntrada {
    private Long id;
    private String nome;
    @Email
    private String email;
    private String telefone;
    private Long pontos;
}
