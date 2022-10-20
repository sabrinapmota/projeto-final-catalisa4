package com.api.doacaopontos.services;

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

    public List<ItemDoado> listarTodos() {
        return itemDoadoRepository.findAll();
    }

    public Optional<ItemDoado> buscarId(Long id) {
        return itemDoadoRepository.findById(id);
    }

    public ItemDoado cadastrar(ItemDoado itemDoado) {
        itemDoado.setIdPessoaDoadora(itemDoado.getUsuarioModel().getId());
        itemDoado.setStatus("ABERTO");
        return itemDoadoRepository.save(itemDoado);
    }

    public void deletarItem(Long id) {
        itemDoadoRepository.deleteById(id);
    }

    public ItemDoado reservarItem(ItemDoado itemDoado) {
        if (itemDoado.getIdPessoaRecebedora() != null) {
            itemDoado.setStatus("RESERVADO");
        }if(itemDoado.getPontosRecebedor()>50L)
             throw  new RuntimeException("Erro: O limite de pontos é 50");
        Long pontos = itemDoado.getPontosDoador();
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
        UsuarioModel usuario = usuarioService.buscarId(itemDoado.getUsuarioModel().getId()).orElseThrow();
        usuarioService.incrementaPontos(usuario, pontos);
        return itemDoadoRepository.save(itemDoado);
    }
}

