package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.UsuarioDto;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository cadastroDoadorRepository;

    public List<UsuarioDto> buscarTodos() {
        List<UsuarioModel> buscarDoadores = cadastroDoadorRepository.findAll();
        return buscarDoadores.stream().map(cadastro -> new UsuarioDto(cadastro.getNome(),cadastro.getCpf(),cadastro.getEmail(),cadastro.getTelefone(),cadastro.getCep(), cadastro.getEndereco(),cadastro.getBairro(), cadastro.getPontos())).collect(Collectors.toList());

    }

    public Optional<UsuarioModel> buscarId(UUID id) {
        return cadastroDoadorRepository.findById(id);
    }

    @Transactional
   public UsuarioModel cadastrarDoador(UsuarioModel usuarioModel) {
        return cadastroDoadorRepository.save(usuarioModel);
    }

    @Transactional
    public UsuarioModel alterarCadastro(UsuarioModel usuarioModel) {
        return cadastroDoadorRepository.save(usuarioModel);
    }

    @Transactional
    public void deletarCadastro(UUID id) {
        cadastroDoadorRepository.deleteById(id);
    }
}