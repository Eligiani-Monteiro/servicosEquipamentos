package com.ifms.br.dto;

import java.io.Serializable;

import com.ifms.br.entities.Equipamento;
import com.ifms.br.entities.GrupoEquipamento;

public class GrupoEquipamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;

	public GrupoEquipamentoDTO(){
	
	}

	public GrupoEquipamentoDTO(Long id, String nome){
		this.id = id;
		this.nome = nome;
	}


	public GrupoEquipamentoDTO(GrupoEquipamento entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();

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
	
}
