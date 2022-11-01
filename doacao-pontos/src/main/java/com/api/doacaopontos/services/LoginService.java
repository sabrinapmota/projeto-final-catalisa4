package com.api.doacaopontos.services;


import com.api.doacaopontos.model.LoginModel;
import com.api.doacaopontos.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    LoginRepository repository;

    public List<LoginModel> buscarTodos() {
        return repository.findAll();
    }

    public Optional<LoginModel> buscarId(UUID userId) {
        return repository.findById(userId);
    }

    public LoginModel cadastrar(LoginModel loginModel) {
        String passwordEncrypted = new BCryptPasswordEncoder().encode(loginModel.getPassword());
        loginModel.setPassword(passwordEncrypted);
        return repository.save(loginModel);
    }

    public void deletar(UUID userId) {
        repository.deleteById(userId);
    }
}

