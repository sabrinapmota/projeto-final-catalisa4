package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.*;
import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import com.api.doacaopontos.services.ItemDoadosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/item-doado")
@Slf4j
public class ItemDoadoController {

    @Autowired
    ItemDoadosService itemDoadosService;

    private final  ItemDoadoRepository itemDoadoRepository;

    public ItemDoadoController( ItemDoadoRepository itemDoadoRepository){
        this.itemDoadoRepository = itemDoadoRepository;}

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping
   public ResponseEntity<List<SaidaNomeDto>> mostrarItems() {
        return ResponseEntity.ok(itemDoadosService.buscarTodos());
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ItemDoado>>exibirPorId(@PathVariable Long id) {
        return ResponseEntity.ok(itemDoadosService.buscarId(id));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping
    public ResponseEntity<ItemSaidaDto> cadastroItem(@RequestBody @Valid ItemDtoEntrada itemDtoEntrada){
        log.info("Recebendo solicitação de cadastro da doação: {}",itemDtoEntrada);
        ItemSaidaDto dtoResposta = itemDoadosService.cadastrarItem(itemDtoEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoResposta);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping(path = "/{id_item}/reservar-doacao")
    public ResponseEntity<ItemDoado> pontosDoado (@RequestBody @Valid ItemReservaDto dto,@PathVariable ("id_item") Long id ) {
        return ResponseEntity.ok(itemDoadosService.reservarItem(id,dto));
    }
//    @CrossOrigin(origins = "http://127.0.0.1:5500")
//    @PostMapping(path = "/{id}/finalizar-doacao")
//    public ResponseEntity<ItemDoado> pontosDoador(@RequestBody ItemDoado itemDoado) {
//        return ResponseEntity.ok(itemDoadosService.fecharItem(itemDoado));
   // }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/status/{status}")
    public List<ItemSaidaDto> buscarPorStatus(@PathVariable String status)
    { return this.itemDoadoRepository.findByStatus(status).stream().map(SaidaPorNomeDto::convert).collect(Collectors.toList());}
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(path = "/nome/{nome}")
    public List<ItemSaidaDto> buscarPorNome(@PathVariable String nome){
        return this.itemDoadoRepository.findByNome(nome).stream().map(SaidaPorNomeDto::convert).collect(Collectors.toList());}
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping(path = "/{id}")
    public void deletarItem(@PathVariable Long id) {itemDoadosService.deletarItem(id);}
}
