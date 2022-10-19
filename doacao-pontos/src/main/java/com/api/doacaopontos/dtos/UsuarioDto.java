package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nome;
    @Email
    private String email;
    private String telefone;
    private Long pontos;
}
