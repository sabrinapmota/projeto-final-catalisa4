package com.api.doacaopontos.controller;


import com.api.doacaopontos.model.LoginModel;
import com.api.doacaopontos.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping ("/login")
public class LoginController {

    @Autowired
    LoginService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<LoginModel>> mostrarLogin() {
        return ResponseEntity.ok(service.buscarTodos());
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping(path = "/{userId}")
    public ResponseEntity<Optional<LoginModel>>exibirPorId(@PathVariable UUID userId) {
        return ResponseEntity.ok(service.buscarId(userId));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping(path = "/create")
    public ResponseEntity<LoginModel> cadastrarLogin(@RequestBody LoginModel loginModel){
        return new ResponseEntity<>(service.cadastrar(loginModel), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path ="/{userId}")
    public void deletar(@PathVariable UUID userId){
        service.deletar(userId);
    }
}
