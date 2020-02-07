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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.riotinto.prontuario.model.Paciente;
import com.riotinto.prontuario.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacientes;
	
	@GetMapping
	public List<Paciente> listar() {
		return pacientes.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
		Optional<Paciente> paciente = pacientes.findById(id);
		
		if (paciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(paciente.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente adicionar(@Valid @RequestBody Paciente paciente) {
		Optional<Paciente> pacienteExistente = pacientes.findByNomeAndSobrenomeAndDataNascimento
				(paciente.getNome(), paciente.getSobrenome(), paciente.getDataNascimento());
		
		if (pacienteExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um paciente com o mesmo nome, sobrenome e data de nascimento!");
		}
		
		return pacientes.save(paciente);
	}
	
	
}