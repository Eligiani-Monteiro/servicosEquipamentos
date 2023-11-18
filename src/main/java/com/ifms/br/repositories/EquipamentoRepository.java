package com.ifms.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifms.br.entities.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento,Long>{

}
