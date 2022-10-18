package com.api.doacaopontos.controller;

import com.api.doacaopontos.dtos.DtoBeneficiario;
import com.api.doacaopontos.model.BeneficiarioModel;
import com.api.doacaopontos.services.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @GetMapping(path = "/consultaTodosBeneficiarios")
    public ResponseEntity<List<DtoBeneficiario>>buscarTudo(){
        return ResponseEntity.ok(beneficiarioService.buscarTudo());
    }

    @GetMapping(path = "/consultaBeneficiarios/{id}")
    public Optional<BeneficiarioModel> buscaId(@PathVariable Long id){
        return beneficiarioService.buscaPorId(id);
    }

    @PostMapping(path = "/cadastroBeneficiario")
    @ResponseStatus(HttpStatus.CREATED)
    public BeneficiarioModel cadastraBeneficiario (@RequestBody BeneficiarioModel beneficiarioModel){
        return beneficiarioService.cadastroBeneficiario(beneficiarioModel);
    }

    @PutMapping(path = "/alterarBeneficiario/{id}")
    public BeneficiarioModel alteraCadastro(@ RequestBody BeneficiarioModel beneficiarioModel){
        return beneficiarioService.alteraBeneficiario(beneficiarioModel);
    }

    @DeleteMapping(path = "/deletarBeneficiario/{id}")
    public void deletaBeneficiario(@PathVariable Long id){
        beneficiarioService.deletaBeneficiario(id);
    }
}

