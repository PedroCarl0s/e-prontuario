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

import com.riotinto.prontuario.model.Prontuario;
import com.riotinto.prontuario.repository.ProntuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/prontuario")
@CrossOrigin(origins = "*")
@Api(value = "Prontuario", tags = { "Prontuário" })
@ApiModel(description = "asfdasdfasdf", value = "asdfasdf")
public class ProntuarioController {

	@Autowired
	private ProntuarioRepository prontuarios;
	
	@ApiOperation(value = "Lista todos os prontuários cadastrados", produces = "application/json")
	@GetMapping
	public List<Prontuario> listar() {
		return prontuarios.findAll();
	}
	
	@ApiOperation(value = "Busca um prontuário pelo ID", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Prontuario> buscar(@PathVariable Long id) {
		Optional<Prontuario> prontuario = prontuarios.findById(id);
		
		if (prontuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prontuario.get());
	}
	
	@ApiOperation(value = "Adiciona um prontuário", produces = "application/json")
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
	
	@ApiOperation(value = "Atualiza um prontuário", produces = "application/json")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Prontuario atualizar(@Valid @RequestBody Prontuario prontuario) {
		return prontuarios.save(prontuario);
	}
	
	@ApiOperation(value = "Deleta um prontuário pelo ID", produces = "application/json")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id ) {
		Optional<Prontuario> prontuario = prontuarios.findById(id);
		
		if (prontuario.isPresent()) {
			prontuarios.deleteById(id);
		
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não há um prontuário com o ID " + id);
		}
		
	}
	
}