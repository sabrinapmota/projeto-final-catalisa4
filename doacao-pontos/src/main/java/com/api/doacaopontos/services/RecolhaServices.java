package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.DtoRecolha;
import com.api.doacaopontos.model.RecolhaModel;
import com.api.doacaopontos.repository.RecolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class RecolhaServices {

    @Autowired
    private RecolhaRepository repository;
    public List<DtoRecolha> buscarTodos(){
        List<RecolhaModel> buscarRecolha = repository.findAll();
        return buscarRecolha.stream().map(recolha ->
                new DtoRecolha(recolha.getNomeItem(), recolha.getCateroriaItem(), recolha.getPontos()))
                .collect(Collectors.toList());
    }
    public Optional<RecolhaModel> buscaPorId(Long id)
    {
        return repository.findById(id);
    }

    public RecolhaModel cadastrarRecolha(RecolhaModel recolhaModel){
        return repository.save(recolhaModel);
    }

    public RecolhaModel atualizaRecolha(RecolhaModel recolhaModel){
        return repository.save(recolhaModel);
    }

    public void deletaRecolha (Long id) {
        repository.deleteById(id);
    }
}
