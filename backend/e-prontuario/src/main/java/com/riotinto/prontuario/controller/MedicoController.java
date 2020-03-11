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

import com.riotinto.prontuario.model.Medico;
import com.riotinto.prontuario.service.MedicoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/medico")
@CrossOrigin(origins = "*")
@Api(value = "Medico", tags = { "Médico" })
public class MedicoController {

	@Autowired
    private MedicoService medicoService;
    

	@ApiOperation(value = "Lista todos os médicos cadastrados", produces = "application/json")
	@GetMapping
	public List<Medico> listar() {
		return medicoService.findAll();
	}
	
	@ApiOperation(value = "Busca um médico pelo ID", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Medico> buscar(@PathVariable Long id) {
		Optional<Medico> medico = medicoService.findById(id);
		
		if (!medico.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(medico.get());
	}
	
	@ApiOperation(value = "Adiciona um médico", produces = "application/json")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico adicionar(@Valid @RequestBody Medico medico) {
		Optional<Medico> medicoExistente = medicoService.findByCrm(medico.getCrm());
		
		if (medicoExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um médico com o CRM " + medico.getCrm());
		}
		
		return medicoService.save(medico);
	}
	
	@ApiOperation(value = "Atualiza um médico pelo ID", produces = "application/json")
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Medico> atualizar(@Valid @RequestBody Medico medico, @PathVariable("id") Long id) {
		Optional<Medico> medicoExistente = medicoService.findById(id);
		
		if (!medicoExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					"Não existe um médico com o ID " + id);
		}

		medico.setId(id);
		medicoService.save(medico);

		return ResponseEntity.ok().body(medico);
	}
	
	@ApiOperation(value = "Deleta um médico pelo ID", produces = "application/json")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		Optional<Medico> medico = medicoService.findById(id);
		
		if (medico.isPresent()) {
			medicoService.deleteById(id);
		
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não existe um médico com o ID " + id);
		}
	}
	
	
}