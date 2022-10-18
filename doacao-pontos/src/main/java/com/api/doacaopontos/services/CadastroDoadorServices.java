package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.CadastroDoadorDto;
import com.api.doacaopontos.model.CadastroDoadorModel;
import com.api.doacaopontos.repository.ICadastroDoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CadastroDoadorServices {
    @Autowired
    private ICadastroDoadorRepository cadastroDoadorRepository;

    public List<CadastroDoadorDto> buscarTodos() {
        List<CadastroDoadorModel> buscarDoadores = cadastroDoadorRepository.findAll();
        return buscarDoadores.stream().map(cadastro -> new CadastroDoadorDto(cadastro.getNome(),
                cadastro.getCpf(),
                cadastro.getTelefone(),
                cadastro.getCep(),
                cadastro.getEmail()
                cadastro.getBairro())).collect(Collectors.toList());

    }

    public Optional<CadastroDoadorModel> buscarId(UUID id) {
        return cadastroDoadorRepository.findById(id);
    }

    @Transactional
   public CadastroDoadorModel cadastrarDoador(CadastroDoadorModel cadastroDoadorModel) {
        return cadastroDoadorRepository.save(cadastroDoadorModel);
    }

    @Transactional
    public CadastroDoadorModel alterarCadastro(CadastroDoadorModel cadastroDoadorModel) {
        return cadastroDoadorRepository.save(cadastroDoadorModel);
    }

    @Transactional
    public void deletarCadastro(UUID id) {
        cadastroDoadorRepository.deleteById(id);
    }
}