package com.api.doacaopontos.repository;

import com.api.doacaopontos.model.ItemDoado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDoadoRepository extends JpaRepository<ItemDoado, Long> {

    List<ItemDoado> findByStatus(String status);

    List<ItemDoado> findByNome(String nome);

}
