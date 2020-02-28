package com.riotinto.prontuario.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.riotinto.prontuario.model.Paciente;
import com.riotinto.prontuario.service.PacienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/paciente")
@CrossOrigin(origins = "*")
@Api(value = "Paciente", tags = { "Paciente" })
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	
	@ApiOperation(value = "Lista todos os pacientes cadastrados", produces = "application/json")
	@GetMapping
	public List<Paciente> listar() {
		return pacienteService.findAll();
	}
	
	@ApiOperation(value = "Busca um paciente pelo ID", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteService.findById(id);
		
		if (!paciente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(paciente.get());
	}
	
	@ApiOperation(value = "Adiciona um paciente", produces = "application/json")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente adicionar(@Valid @RequestBody Paciente paciente) {
		Optional<Paciente> pacienteExistente = pacienteService.findByNomeAndSobrenomeAndDataNascimento
				(paciente.getNome(), paciente.getSobrenome(), paciente.getDataNascimento());
		
		if (pacienteExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um paciente com o mesmo nome, sobrenome e data de nascimento!");
		}
		
		return pacienteService.save(paciente);
	}
	
	@ApiOperation(value = "Atualiza um paciente", produces = "application/json")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Paciente atualizar(@Valid @RequestBody Paciente paciente) {
		return pacienteService.save(paciente);
	}
	
	@ApiOperation(value = "Deleta um paciente pelo ID", produces = "application/json")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteService.findById(id);
		
		if (paciente.isPresent()) {
			pacienteService.deleteById(id);
		
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não existe um paciente com o ID " + id);
		}
	}
	
	
}