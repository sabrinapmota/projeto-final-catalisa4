package com.api.doacaopontos.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemReservaDto {


    private Long idPessoaRecebedora;

    private Long pontosParaDoador;

}
