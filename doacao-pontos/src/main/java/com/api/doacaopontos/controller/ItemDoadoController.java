package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.ItemSaidaDto;
import com.api.doacaopontos.dtos.SaidaPorNomeDto;
import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import com.api.doacaopontos.services.ItemDoadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/item-doado")
public class ItemDoadoController {

    @Autowired
    ItemDoadosService itemDoadosService;

    private final  ItemDoadoRepository itemDoadoRepository;

    public ItemDoadoController( ItemDoadoRepository itemDoadoRepository){
        this.itemDoadoRepository = itemDoadoRepository;}
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
   public ResponseEntity<List<ItemSaidaDto>> mostrarUsuarios() {
        return ResponseEntity.ok(itemDoadosService.buscarTodos());
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ItemDoado>>exibirPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemDoadosService.buscarId(id));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping
    public ResponseEntity<ItemDoado> cadastroItem(@RequestBody ItemDoado itemDoado){
        ItemDoado itemDoado1 = itemDoadosService.cadastrar( itemDoado);
        return new ResponseEntity<>(itemDoado1, HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/{id}/reservar-doacao")
    public ResponseEntity<ItemDoado> pontosDoado (@RequestBody ItemDoado itemDoado) {
        return ResponseEntity.ok(itemDoadosService.reservarItem(itemDoado));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/{id}/finalizar-doador")
    public ResponseEntity<ItemDoado> pontosDoador(@RequestBody ItemDoado itemDoado) {
        return ResponseEntity.ok(itemDoadosService.fecharItem(itemDoado));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/status/{status}")
    public List<ItemSaidaDto> buscarPorStatus(@PathVariable String status)
    { return this.itemDoadoRepository.findByStatus(status).stream().map(SaidaPorNomeDto::convert).collect(Collectors.toList());}
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/nome/{nome}")
    public List<ItemSaidaDto> buscarPorNome(@PathVariable String nome){
        return this.itemDoadoRepository.findByNome(nome).stream().map(SaidaPorNomeDto::convert).collect(Collectors.toList());}
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deletarItem(@PathVariable Long id) {itemDoadosService.deletarItem(id);}
}
