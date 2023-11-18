package com.ifms.br.dto;

import java.io.Serializable;
import java.util.Objects;

import com.ifms.br.entities.Equipamento;
import com.ifms.br.entities.GrupoEquipamento;

public class EquipamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private GrupoEquipamento grupoEquipamento;

	public EquipamentoDTO() {

	}

	public EquipamentoDTO(Long id, String nome,GrupoEquipamento grupoEquipamento) {

		this.id = id;
		this.nome = nome;
		this.grupoEquipamento = grupoEquipamento;
		
	}

	public EquipamentoDTO(Equipamento entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.grupoEquipamento = entity.getGrupoEquipamento();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrupoEquipamento getGrupoEquipamento() {
		return grupoEquipamento;
	}

	public void setGrupoEquipamento(GrupoEquipamento grupoEquipamento) {
		this.grupoEquipamento = grupoEquipamento;
	}
}
