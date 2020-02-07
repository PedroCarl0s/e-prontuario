package com.riotinto.prontuario.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.riotinto.prontuario.model.Prontuario;
import com.riotinto.prontuario.repository.ProntuarioRepository;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController {

	@Autowired
	private ProntuarioRepository prontuarios;
	
	@GetMapping
	public List<Prontuario> listar() {
		return prontuarios.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Prontuario> buscar(@PathVariable Long id) {
		Optional<Prontuario> prontuario = prontuarios.findById(id);
		
		if (prontuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prontuario.get());
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Prontuario adicionar(@Valid @RequestBody Prontuario prontuario) {
		Optional<Prontuario> prontuarioExistente = prontuarios.findByIdAndNomePacienteAndQueixaPrincipal(
				prontuario.getId(), prontuario.getNomePaciente(), prontuario.getQueixaPrincipal());
		
		if (prontuarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe um prontuário com o ID " + prontuario.getId());
		}
		
		return prontuarios.save(prontuario);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Prontuario atualizar(@Valid @RequestBody Prontuario prontuario) {
		return prontuarios.save(prontuario);
	}
	
	
	
}