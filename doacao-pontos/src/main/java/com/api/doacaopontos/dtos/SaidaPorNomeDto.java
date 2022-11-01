package com.api.doacaopontos.dtos;

import com.api.doacaopontos.model.ItemDoado;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaidaPorNomeDto {

    private Long id;
    private String nome;
    private String descricao;
    private Long idPessoaDoadora;
    private String status;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String nomeDoador;
    private String telefone;
    private String email;

    public static ItemSaidaDto convert(ItemDoado itemDoado) {
        var item = new ItemSaidaDto();
        item.setId(item.getId());
        item.setNome(itemDoado.getNome());
        item.setDescricao(itemDoado.getDescricao());
        item.setIdPessoaDoadora(itemDoado.getPessoaDoadora().getId());
        item.setStatus(itemDoado.getStatus());
        item.setDataInicio(itemDoado.getDataInicio());
        item.setNomeDoador(itemDoado.getPessoaDoadora().getNome());
        item.setTelefone(itemDoado.getPessoaDoadora().getTelefone());
        item.setEmail(itemDoado.getPessoaDoadora().getEmail());

        return item;
    }
}
