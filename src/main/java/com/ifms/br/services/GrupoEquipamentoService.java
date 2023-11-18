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
import com.ifms.br.dto.GrupoEquipamentoDTO;
import com.ifms.br.entities.Equipamento;
import com.ifms.br.entities.GrupoEquipamento;
import com.ifms.br.exceptions.DataBaseException;
import com.ifms.br.exceptions.ResourceNotFoundException;
import com.ifms.br.repositories.EquipamentoRepository;
import com.ifms.br.repositories.GrupoEquipamentoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GrupoEquipamentoService {
	
	@Autowired
	private GrupoEquipamentoRepository repository;
	
	
	public GrupoEquipamentoDTO findByID(Long id) {
		Optional<GrupoEquipamento> obj = Optional.empty();
		GrupoEquipamento equi = obj.orElseThrow(() -> new ResourceAccessException("O Equipamento não foi localizado"));
		return new GrupoEquipamentoDTO();
	}
	
	public List<GrupoEquipamentoDTO> findAll() {
		List<GrupoEquipamento> list = repository.findAll();
		return list.stream().map(equi -> new GrupoEquipamentoDTO(equi)).collect(Collectors.toList());

	}
	@Transactional
	public GrupoEquipamentoDTO create(GrupoEquipamentoDTO dto) {
		GrupoEquipamento equi = new GrupoEquipamento();
		equi.setNome(dto.getNome());
		return new GrupoEquipamentoDTO(equi);
	}
	

	public GrupoEquipamentoDTO update(Long id, GrupoEquipamentoDTO dto) {
		try {
			GrupoEquipamento equi = repository.getById(id);
		    equi.setNome(dto.getNome()); 
		    return new GrupoEquipamentoDTO(repository.save(equi));
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


