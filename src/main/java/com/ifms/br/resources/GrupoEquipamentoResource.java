package com.ifms.br.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ifms.br.dto.EquipamentoDTO;
import com.ifms.br.dto.GrupoEquipamentoDTO;
import com.ifms.br.services.EquipamentoService;
import com.ifms.br.services.GrupoEquipamentoService;

@RestController
@RequestMapping(value = "/grupoequipamentos")
public class GrupoEquipamentoResource {

	@Autowired
	private GrupoEquipamentoService service;

	@GetMapping
	public ResponseEntity<List<GrupoEquipamentoDTO>> findAll() {
		List<GrupoEquipamentoDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<GrupoEquipamentoDTO> findById(@PathVariable Long id) {
		GrupoEquipamentoDTO dto = service.findByID(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<GrupoEquipamentoDTO> insert(@RequestBody GrupoEquipamentoDTO dto) {
		dto = service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<GrupoEquipamentoDTO> update(@PathVariable Long id, @RequestBody GrupoEquipamentoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<GrupoEquipamentoDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
