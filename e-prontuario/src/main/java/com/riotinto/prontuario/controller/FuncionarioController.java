package com.riotinto.prontuario.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.riotinto.prontuario.model.Funcionario;
import com.riotinto.prontuario.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/funcionario")
@CrossOrigin(origins = "*")
@Api(value = "Funcionario", tags = { "Funcionário" })
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionariosService;
	
	@ApiOperation(value = "Lista todos os funcionários cadastrados", produces = "application/json")
	@GetMapping
	public List<Funcionario> listar() {
		return funcionariosService.findAll();
	}
	
	@ApiOperation(value = "Busca um funcionário pelo ID", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionariosService.findById(id);
				
		if (!funcionario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(funcionario.get());
	}
	
	@ApiOperation(value = "Adiciona um funcionário", produces = "application/json")
	@PostMapping
	public ResponseEntity<Funcionario> adicionar(@Valid @RequestBody Funcionario funcionario) {
		Optional<Funcionario> funcionarioExistente = funcionariosService.findByNomeAndSobrenomeAndTipo(
				funcionario.getNome(), funcionario.getSobrenome(), funcionario.getTipo());
		
		if (funcionarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe um funcionário com o mesmo nome, sobrenome e tipo");
		}
				
		funcionariosService.save(funcionario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(funcionario.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Atualiza um funcionário", produces = "application/json")
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@Valid @RequestBody Funcionario funcionario, @PathVariable Long id) {
		Optional<Funcionario> funcionarioExistente = funcionariosService.findById(id);
		
		if (!funcionarioExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		funcionario.setId(id);
		funcionariosService.save(funcionario);
		
		return ResponseEntity.ok().body(funcionario);
	}
	
	@ApiOperation(value = "Deleta um funcionário pelo ID", produces = "application/json")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionariosService.findById(id);
		
		if (funcionario.isPresent()) {
			funcionariosService.delete(id);
			
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Não há funcionário com o ID " + id);
		}
		
	}
	
}