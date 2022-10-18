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
public class CadastroDoadorDto {
    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private
    String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 12)
    private String telefone;

    @NotBlank
    @Size(max = 8)
    private String cep;
    @NotBlank
    private String endereco;
    @NotBlank
    private String bairro;
    @Size(max = 5)
    private String pontos;
}
