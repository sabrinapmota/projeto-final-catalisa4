package com.api.doacaopontos.repository;

import com.api.doacaopontos.model.CadastroDoadorModel;
import org.hibernate.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICadastroDoadorRepository extends JpaRepository<CadastroDoadorModel, UUID> {
}
