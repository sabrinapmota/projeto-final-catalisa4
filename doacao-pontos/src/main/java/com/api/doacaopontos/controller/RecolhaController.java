package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.DtoRecolha;
import com.api.doacaopontos.model.RecolhaModel;
import com.api.doacaopontos.services.RecolhaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "/recolha")

public class RecolhaController {

    @Autowired
    RecolhaServices service;

    @GetMapping
    public ResponseEntity<List<DtoRecolha>> exibirRecolhas(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<RecolhaModel>>mostrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscaPorId(id));
    }
    @PostMapping
    public ResponseEntity<RecolhaModel> cadastrarRecolha(@RequestBody RecolhaModel recolhaModel){
        return new ResponseEntity<>(service.cadastrarRecolha(recolhaModel), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RecolhaModel> atualizaRecolha(@RequestBody RecolhaModel recolhaModel) {
        return ResponseEntity.ok(recolhaModel);
    }

    @DeleteMapping(path = "/{id}")
    public void deletarRecolha(@PathVariable Long id) {
        service.deletaRecolha(id);}
}

