package com.api.doacaopontos.security;

import com.api.doacaopontos.model.LoginModel;
import com.api.doacaopontos.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nomelogin) throws UsernameNotFoundException {
        LoginModel loginModel = repository.findByNomeLogin(nomelogin)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado" + nomelogin));
        return loginModel;
    }
}
