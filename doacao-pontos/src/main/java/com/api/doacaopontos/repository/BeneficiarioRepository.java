package com.api.doacaopontos.repository;

import com.api.doacaopontos.model.BeneficiarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<BeneficiarioModel,Long> {

}
