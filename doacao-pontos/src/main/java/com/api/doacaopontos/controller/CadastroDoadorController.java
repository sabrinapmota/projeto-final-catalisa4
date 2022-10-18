package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.CadastroDoadorDto;
import com.api.doacaopontos.model.CadastroDoadorModel;
import com.api.doacaopontos.services.CadastroDoadorServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cadastro")
public class CadastroDoadorController {
    @Autowired
    private CadastroDoadorServices cadastroDoadorServices;

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid CadastroDoadorDto cadastroDoadorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroDoadorServices.cadastrarDoador(new CadastroDoadorModel()));
    }

    @GetMapping
    public ResponseEntity<List<CadastroDoadorDto>> buscartodos() {
        return ResponseEntity.ok(cadastroDoadorServices.buscarTodos());
    }

    @GetMapping("/{id}")
    public Optional<CadastroDoadorModel> buscarID(@PathVariable(value = "id") UUID id) {
        return cadastroDoadorServices.buscarId(id);
    }

    @PutMapping("/{id}")
    public CadastroDoadorModel alterarCadastro(@RequestBody CadastroDoadorModel cadastroDoadorModel) {
        return cadastroDoadorServices.alterarCadastro(cadastroDoadorModel);
    }

    @DeleteMapping("/{id}")
    public void deletarCadastro(@PathVariable(value = "id") UUID id) { cadastroDoadorServices.deletarCadastro(id);}
}
