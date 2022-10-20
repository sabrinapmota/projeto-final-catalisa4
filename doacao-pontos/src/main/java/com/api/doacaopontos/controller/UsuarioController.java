package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.UsuarioDtoEntrada;
import com.api.doacaopontos.dtos.UsuarioDtoSaida;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/cadastro")
    public ResponseEntity<UsuarioDtoSaida> cadastrar(@RequestBody @Valid UsuarioDtoEntrada usuarioDtoEntrada ) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarDoador(usuarioDtoEntrada));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDtoEntrada>> buscartodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> buscarID(@PathVariable(value = "id") Long id) {
        return usuarioService.buscarId(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel alterarCadastro(@RequestBody UsuarioModel usuarioModel) {
        return usuarioService.alterarCadastro(usuarioModel);
    }

    @DeleteMapping("/{id}")
    public void deletarCadastro(@PathVariable(value = "id") Long id) { usuarioService.deletarCadastro(id);}
}
