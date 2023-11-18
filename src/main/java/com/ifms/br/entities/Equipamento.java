package com.ifms.br.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "tb_equipamento")
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToOne 
	@JoinColumn(name = "grupo_equipamento_id")
	private GrupoEquipamento grupoEquipamento;
	
	
	public Equipamento() {

	}

	public Equipamento(Long id, String nome,GrupoEquipamento grupoEquipamento) {
		this.id = id;
		this.nome = nome;
		this.grupoEquipamento = grupoEquipamento;;
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

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	public GrupoEquipamento getGrupoEquipamento() {
		return grupoEquipamento;
	}

	public void setGrupoEquipamento(GrupoEquipamento grupoEquipamento) {
		this.grupoEquipamento = grupoEquipamento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		return Objects.equals(nome, other.nome);
	}

}
