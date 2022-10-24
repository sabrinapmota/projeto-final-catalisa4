package com.api.doacaopontos.repository;

import com.api.doacaopontos.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, UUID> {

    Optional<LoginModel>findByNomeLogin(String nomelogin);
}
