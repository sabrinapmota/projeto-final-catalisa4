package com.api.doacaopontos.controller;

import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.model.enuns.SelecaoCategoria;
import com.api.doacaopontos.model.somaPontos.PontosCategoria;
import com.api.doacaopontos.model.somaPontos.PontosEstetica;
import com.api.doacaopontos.model.somaPontos.PontosEstrutura;
import com.api.doacaopontos.model.somaPontos.PontosFuncional;
import com.api.doacaopontos.services.ItemDoadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/doar")
public class ItemDoadoController {

    @Autowired
    ItemDoadosService itemDoadosService;

    @GetMapping
    public ResponseEntity<List<ItemDoado>> exibirItens(){
        return ResponseEntity.ok(itemDoadosService.listarTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ItemDoado>>exibirPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemDoadosService.buscarId(id));
    }

    @PostMapping
    public ResponseEntity<ItemDoado> cadastroItem(@RequestBody ItemDoado itemDoado){
        ItemDoado itemDoado1 = itemDoadosService.cadastrar( itemDoado);
        return new ResponseEntity<>(itemDoado1, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ItemDoado> alterarItem(@RequestBody ItemDoado itemDoado) {
        return ResponseEntity.ok(itemDoadosService.cadastrar(itemDoado));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarItem(@PathVariable Long id) {itemDoadosService.deletarItem(id);}
}
