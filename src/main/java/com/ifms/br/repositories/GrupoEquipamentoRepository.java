package com.ifms.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.br.entities.GrupoEquipamento;

@Repository
public interface GrupoEquipamentoRepository extends JpaRepository<GrupoEquipamento, Long>{

}
