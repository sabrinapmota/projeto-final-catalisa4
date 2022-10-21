package com.api.doacaopontos.controller;

import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.services.ItemDoadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/item-doado")
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

    @PostMapping(path = "/{id}/reservar-doacao")
    public ResponseEntity<ItemDoado> pontosDoado (@RequestBody ItemDoado itemDoado) {
        return ResponseEntity.ok(itemDoadosService.reservarItem(itemDoado));
    }

    @PostMapping(path = "/{id}/finalizar-doador")
    public ResponseEntity<ItemDoado> pontosDoador(@RequestBody ItemDoado itemDoado) {
        return ResponseEntity.ok(itemDoadosService.fecharItem(itemDoado));
    }

    @GetMapping(path = "/status/{status}")
    public List<ItemDoado> buscarPorStatus(@PathVariable String status){ return itemDoadosService.buscarStatus(status);}

    @GetMapping(path = "/nome/{nome}")
    public List<ItemDoado> buscarPorNome(@PathVariable String nome){ return itemDoadosService.buscarnNome(nome);}
    @DeleteMapping(path = "/{id}")
    public void deletarItem(@PathVariable Long id) {itemDoadosService.deletarItem(id);}
}
