package com.riotinto.prontuario.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.riotinto.prontuario.model.Funcionario;
import com.riotinto.prontuario.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarios;
	
	
	@GetMapping
	public List<Funcionario> listar() {
		return funcionarios.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarios.findById(id);
		
		if (funcionario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(funcionario.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario adicionar(@Valid @RequestBody Funcionario funcionario) {
		Optional<Funcionario> funcionarioExistente = funcionarios.findByNomeAndSobrenomeAndTipo(
				funcionario.getNome(), funcionario.getSobrenome(), funcionario.getTipo());
		
		if (funcionarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe um funcionário com o mesmo nome, sobrenome e tipo");
		}
		
		return funcionarios.save(funcionario);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(@Valid @RequestBody Funcionario funcionario) {
		funcionarios.save(funcionario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarios.findById(id);
		
		if (funcionario.isPresent()) {
			funcionarios.deleteById(id);	
		
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Não há funcionário com o ID " + id);
		}
		
	}
	
}