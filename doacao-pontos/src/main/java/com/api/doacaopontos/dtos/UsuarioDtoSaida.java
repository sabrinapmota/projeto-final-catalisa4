package com.api.doacaopontos.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDtoSaida {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @Email
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefone")
    private String telefone;

//    public UsuarioDtoSaida(Long id, String nome, String email, String telefone) {
//    }
}
