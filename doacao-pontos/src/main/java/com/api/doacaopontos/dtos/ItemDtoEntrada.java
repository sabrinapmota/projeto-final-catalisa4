package com.api.doacaopontos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDtoEntrada {
    private Long id;
    private String nome;
    private String descricao;
    private Long idPessoaDoadora;

}
