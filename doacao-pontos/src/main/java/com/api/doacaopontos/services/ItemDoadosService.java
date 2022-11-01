package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.*;
import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ItemDoadosService {

    @Autowired
    ItemDoadoRepository itemDoadoRepository;

    @Autowired
    UsuarioService usuarioService;
@Transactional
    public List<SaidaNomeDto> buscarTodos() {
        List<ItemDoado> itemDoados = itemDoadoRepository.findAll();
        return SaidaNomeDto.convert(itemDoados);
    }

    public Optional<ItemDoado> buscarId(Long id) {
        return itemDoadoRepository.findById(id);
    }

    @Transactional
    public ItemSaidaDto cadastrarItem(ItemDtoEntrada itemDtoEntrada) {
        ItemDoado itemDoado = new ItemDoado();
        itemDoado.setDescricao(itemDtoEntrada.getDescricao());
        Optional<UsuarioModel> optionalUsuario = usuarioService.buscarId(itemDtoEntrada.getIdPessoaDoadora());
        UsuarioModel usuarioDoador = optionalUsuario.orElseThrow(() -> new IllegalArgumentException("O Doador com o ID " + itemDtoEntrada.getIdPessoaDoadora() + " não existe no Banco de Dados"));
        itemDoado.setPessoaDoadora(usuarioDoador);
        itemDoado.setNome(itemDtoEntrada.getNome());
        itemDoado.setStatus("ABERTO");
        itemDoado.setDataInicio(LocalDate.now());
        itemDoadoRepository.saveAndFlush(itemDoado);
        return new ItemSaidaDto();
    }
@Transactional
    public List<ItemDoado> buscarStatus(String status){return itemDoadoRepository.findByStatus(status);}
    public List<ItemDoado> buscarNome(String nome){return itemDoadoRepository.findByNome(nome);}
    public void deletarItem(Long id) {
        itemDoadoRepository.deleteById(id);
    }

@Transactional
    public ItemDoado reservarItem(Long idItem, ItemReservaDto reservaDto) {
        if(reservaDto.getPontosParaDoador()>50L)
            throw  new RuntimeException("Erro: O limite de pontos é 50");
        ItemDoado itemDoado = itemDoadoRepository.findById(idItem).orElseThrow(() -> new IllegalArgumentException("O Id do Item " + idItem + " informado não existe no banco de dados"));
        if (itemDoado.getPessoaRecebedora() != null) {
            throw new IllegalArgumentException("Esta doação ja possui recebedor");
        }
        Optional<UsuarioModel> optionalUsuario = usuarioService.buscarId(reservaDto.getIdPessoaRecebedora());
        UsuarioModel usuarioRecebedor = optionalUsuario.orElseThrow(() -> new IllegalArgumentException("O Recebedor com o ID " + reservaDto.getIdPessoaRecebedora() + " não existe no Banco de Dados"));
        itemDoado.setPessoaRecebedora(usuarioRecebedor);
        //TODO criar um enum para o status das reservas;
        itemDoado.setStatus("RESERVADO");
        itemDoado.setPontosDoador(reservaDto.getPontosParaDoador());
        itemDoado.setPessoaRecebedora(usuarioRecebedor);

        usuarioService.incrementaPontos(itemDoado.getPessoaDoadora(), reservaDto.getPontosParaDoador());
        return itemDoadoRepository.saveAndFlush(itemDoado);
    }
@Transactional
    public ItemDoado fecharItem(Long id, FinalizarItemDTO finalizarItemDTO) {

        if(finalizarItemDTO.getPontosParaRecebedor()>50L)
            throw  new IllegalArgumentException("Erro: O limite de pontos é 50");
    ItemDoado itemDoado = itemDoadoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("O Id do Item " + id + " informado não existe no banco de dados"));
        itemDoado.setStatus("FECHADO");
        itemDoado.setDataTermino(LocalDate.now());
        itemDoado.setPontosRecebedor(finalizarItemDTO.getPontosParaRecebedor());
        usuarioService.incrementaPontos(itemDoado.getPessoaRecebedora(), finalizarItemDTO.getPontosParaRecebedor());
        return itemDoadoRepository.saveAndFlush(itemDoado);
    }


}


