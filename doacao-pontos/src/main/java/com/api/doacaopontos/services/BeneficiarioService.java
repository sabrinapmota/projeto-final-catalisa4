package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.DtoBeneficiario;
import com.api.doacaopontos.model.BeneficiarioModel;
import com.api.doacaopontos.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<DtoBeneficiario> buscarTudo(){
        List<BeneficiarioModel> buscarBeneficiarios = beneficiarioRepository.findAll();
        return buscarBeneficiarios.stream().map(beneficiario -> new DtoBeneficiario(beneficiario.getNomeBeneficiario(), beneficiario.getEnderecoBeneficiario(), beneficiario.getBairroBeneficiario(), beneficiario.getEmailBeneficiario())).collect(Collectors.toList());
    }

    public Optional<BeneficiarioModel> buscaPorId(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public BeneficiarioModel cadastroBeneficiario(BeneficiarioModel beneficiarioModel){
        return beneficiarioRepository.save(beneficiarioModel);
    }

    public BeneficiarioModel alteraBeneficiario(BeneficiarioModel beneficiarioModel){
        return beneficiarioRepository.save(beneficiarioModel);
    }

    public void deletaBeneficiario (Long id){
        beneficiarioRepository.deleteById(id);
    }


}
