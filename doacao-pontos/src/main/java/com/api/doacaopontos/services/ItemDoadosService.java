package com.api.doacaopontos.services;

import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.model.enuns.SelecaoCategoria;
import com.api.doacaopontos.model.somaPontos.PontosCategoria;
import com.api.doacaopontos.model.somaPontos.PontosEstetica;
import com.api.doacaopontos.model.somaPontos.PontosEstrutura;
import com.api.doacaopontos.model.somaPontos.PontosFuncional;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDoadosService {

    @Autowired
    ItemDoadoRepository itemDoadoRepository;

    public List<ItemDoado>listarTodos(){return itemDoadoRepository.findAll();}

    public Optional<ItemDoado>buscarId(Long id){return itemDoadoRepository.findById(id);}

    public ItemDoado cadastrar(ItemDoado itemDoado, PontosEstetica pontosEstetica, PontosEstrutura pontosEstrutura, PontosFuncional pontosFuncional,
                               PontosCategoria pontosCategoria, SelecaoCategoria selecaoCategoria){
       String categoria= selecaoCategoria.categoria(itemDoado.getCategoria());
       itemDoado.setCategoria(categoria);
        Long pntEstica =  pontosEstetica.categoria(itemDoado.getEstetica());
        Long pntEstrutura =  pontosEstrutura.categoria(itemDoado.getEstrutura());
        Long pntFuncional =  pontosFuncional.categoria(itemDoado.getFuncional());
        Long pntCategoria =  pontosCategoria.categoria((itemDoado.getCategoria()));
        itemDoado.setTotalPontos(pntEstica + pntEstrutura + pntFuncional + pntCategoria);
        return itemDoadoRepository.save(itemDoado);
    }

    public void deletarItem(Long id){itemDoadoRepository.deleteById(id);}
}
