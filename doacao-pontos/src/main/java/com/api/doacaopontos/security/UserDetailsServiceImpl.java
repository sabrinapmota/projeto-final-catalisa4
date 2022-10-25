package com.api.doacaopontos.security;

import com.api.doacaopontos.model.LoginModel;
import com.api.doacaopontos.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional //Assim o metodo UserDetails buscar os dados ao BD ele vai ter acesso aos dados
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nomelogin) throws UsernameNotFoundException {

        LoginModel loginModel = repository.findByNomeLogin(nomelogin)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado" + nomelogin));
        return new User(loginModel.getUsername(),loginModel.getPassword(), true, true, true, true, loginModel.getAuthorities());
    }
}
