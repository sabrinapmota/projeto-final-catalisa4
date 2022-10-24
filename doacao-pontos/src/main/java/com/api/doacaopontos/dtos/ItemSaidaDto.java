package com.api.doacaopontos.dtos;

import com.api.doacaopontos.model.ItemDoado;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemSaidaDto {
    private Long id;
    private String nome;
    private String descricao;
    private Long idPessoaDoadora;
    private String status;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String nomeDoador;
    private String email;

    private String telefone;

    public ItemSaidaDto(ItemDoado itemDoado){
        this.id = itemDoado.getId();
        this.nome = itemDoado.getNome();
        this.descricao = itemDoado.getDescricao();
        this.idPessoaDoadora = itemDoado.getIdPessoaDoadora();
        this.status = itemDoado.getStatus();
        this.dataInicio = itemDoado.getDataInicio();
        this.dataTermino = itemDoado.getDataTermino();
        this.nomeDoador = itemDoado.getUsuarioModel().getNome();
        this.email = itemDoado.getUsuarioModel().getEmail();
        this.telefone = itemDoado.getUsuarioModel().getTelefone();
    }

    public  static List<ItemSaidaDto> convert(List<ItemDoado> itemDoados){
        return itemDoados.stream().map(ItemSaidaDto::new).collect(Collectors.toList());
    }
}
