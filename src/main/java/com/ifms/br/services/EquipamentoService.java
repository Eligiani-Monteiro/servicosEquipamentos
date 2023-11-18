package com.ifms.br.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import com.ifms.br.dto.EquipamentoDTO;
import com.ifms.br.entities.Equipamento;
import com.ifms.br.exceptions.DataBaseException;
import com.ifms.br.exceptions.ResourceNotFoundException;
import com.ifms.br.repositories.EquipamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipamentoService {
	@Autowired
	private EquipamentoRepository repository;

	public EquipamentoDTO findByID(Long id) {
		Optional<Equipamento> obj = repository.findById(id);
		Equipamento equi = obj.orElseThrow(() -> new ResourceAccessException("O Equipamento não foi localizado"));
		return new EquipamentoDTO(equi);
	}

	public List<EquipamentoDTO> findAll() {
		List<Equipamento> list = repository.findAll();
		return list.stream().map(equi -> new EquipamentoDTO(equi)).collect(Collectors.toList());

	}

	@Transactional
	public EquipamentoDTO create(EquipamentoDTO dto) {
		Equipamento equi = new Equipamento();
		equi.setNome(dto.getNome());
		return new EquipamentoDTO(equi);
	}

	public EquipamentoDTO update(Long id, EquipamentoDTO dto) {
		try {
			Equipamento equi = repository.getById(id);
		    equi.setNome(dto.getNome()); 
		    return new EquipamentoDTO(repository.save(equi));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Equipamento não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possivel excluir, id do equipamento não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não foi possível excluir equipamento pois o mesmo está em uso");
		}

	}

}
