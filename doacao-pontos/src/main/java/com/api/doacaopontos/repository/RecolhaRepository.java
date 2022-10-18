package com.api.doacaopontos.repository;

import com.api.doacaopontos.model.RecolhaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecolhaRepository extends JpaRepository<RecolhaModel, Long> {
}
