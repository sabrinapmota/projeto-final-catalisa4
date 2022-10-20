package com.api.doacaopontos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDtoSaida {

    private Long id;
    private  String nome;
    private String email;
    private String telefone;

    public UsuarioDtoSaida(Long id, String nome, String email, String telefone){}
}
