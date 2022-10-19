package com.api.doacaopontos.services;

import com.api.doacaopontos.dtos.UsuarioDto;
import com.api.doacaopontos.model.UsuarioModel;
import com.api.doacaopontos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository cadastroDoadorRepository;

    public List<UsuarioDto> buscarTodos() {
        List<UsuarioModel> buscarDoadores = cadastroDoadorRepository.findAll();
        return buscarDoadores.stream().map(cadastro -> new UsuarioDto(cadastro.getId(), cadastro.getNome(),
                cadastro.getEmail(), cadastro.getTelefone(), cadastro.getPontos())).collect(Collectors.toList());

    }

    public Optional<UsuarioModel> buscarId(Long id) {
        return cadastroDoadorRepository.findById(id);
    }

    @Transactional
    public UsuarioModel cadastrarDoador(UsuarioModel usuarioModel) {
        usuarioModel.setPontos(0L);
        return cadastroDoadorRepository.save(usuarioModel);
    }

    @Transactional
    public UsuarioModel alterarCadastro(UsuarioModel usuarioModel) {
        return cadastroDoadorRepository.save(usuarioModel);
    }

    @Transactional
    public void deletarCadastro(Long id) {
        cadastroDoadorRepository.deleteById(id);
    }

    @Transactional
    public UsuarioModel incrementaPontos(UsuarioModel usuarioModel, Long pontos){
        usuarioModel.setPontos(usuarioModel.getPontos() + pontos);
        return cadastroDoadorRepository.save(usuarioModel);
    }
}