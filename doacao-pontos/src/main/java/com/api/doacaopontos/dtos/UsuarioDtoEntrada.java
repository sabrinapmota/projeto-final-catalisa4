package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDtoEntrada {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Long pontos;
}
