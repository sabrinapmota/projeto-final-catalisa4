package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.ItemDtoEntrada;
import com.api.doacaopontos.dtos.ItemSaidaDto;
import com.api.doacaopontos.dtos.SaidaNomeDto;
import com.api.doacaopontos.dtos.UsuarioDtoSaida;
import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ItemDoadosService {

    @Autowired
    ItemDoadoRepository itemDoadoRepository;

    @Autowired
    UsuarioService usuarioService;

    public List<SaidaNomeDto> buscarTodos() {
        List<ItemDoado> itemDoados = itemDoadoRepository.findAll();
        return SaidaNomeDto.convert(itemDoados);
    }


    public Optional<ItemDoado> buscarId(Long id) {
        return itemDoadoRepository.findById(id);
    }

    public ItemSaidaDto cadastrarItem(ItemDtoEntrada itemDtoEntrada) {
        ItemDoado itemDoado = new ItemDoado();
        itemDoado.setId(itemDtoEntrada.getId());
        itemDoado.setIdPessoaDoadora(itemDoado.getId());
        itemDoado.setStatus("ABERTO");
        itemDoado.setDataInicio(LocalDate.now());
        itemDoadoRepository.save(itemDoado);
        return new ItemSaidaDto();
    }


    public List<ItemDoado> buscarStatus(String status){return itemDoadoRepository.findByStatus(status);}
    public List<ItemDoado> buscarNome(String nome){return itemDoadoRepository.findByNome(nome);}

    public void deletarItem(Long id) {
        itemDoadoRepository.deleteById(id);
    }

    public ItemDoado reservarItem(ItemDoado itemDoado) {
        if (itemDoado.getIdPessoaRecebedora() != null) {
            itemDoado.setStatus("RESERVADO");
        }if(itemDoado.getPontosRecebedor()>50L)
             throw  new RuntimeException("Erro: O limite de pontos é 50");
        Long pontos = itemDoado.getPontosDoador();
        itemDoado.setPontosRecebedor(0L);
        UsuarioModel usuario = usuarioService.buscarId(itemDoado.getUsuarioModel().getId()).orElseThrow();
        usuarioService.incrementaPontos(usuario, pontos);
        return itemDoadoRepository.save(itemDoado);
    }

    public ItemDoado fecharItem(ItemDoado itemDoado) {
        if(itemDoado.getPontosDoador()>50L){
            throw  new RuntimeException("Erro: O limite de pontos é 50");}
        else { itemDoado.setStatus("FECHADO");
            itemDoado.setDataTermino(LocalDate.now());}
        Long pontos = itemDoado.getPontosRecebedor();
        itemDoado.setPontosDoador(0L);
        UsuarioModel usuario = usuarioService.buscarId(itemDoado.getUsuarioModel().getId()).orElseThrow();
        usuarioService.incrementaPontos(usuario, pontos);
        return itemDoadoRepository.save(itemDoado);
    }
}

