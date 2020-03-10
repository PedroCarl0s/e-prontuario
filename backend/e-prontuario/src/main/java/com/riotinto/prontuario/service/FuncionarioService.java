package com.riotinto.prontuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riotinto.prontuario.model.Funcionario;
import com.riotinto.prontuario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioDAO;
	
	
	public List<Funcionario> findAll() {
		return funcionarioDAO.findAll();
	}
	
	public Optional<Funcionario> findById(Long id) {
		return funcionarioDAO.findById(id);
	}
	
	public Optional<Funcionario> findByNomeAndSobrenomeAndTipo(String nome, String sobrenome, String tipo) {
		return funcionarioDAO.findByNomeAndSobrenomeAndTipo(nome, sobrenome, tipo);
	}
	
	public Funcionario save(Funcionario funcionario) {
		return funcionarioDAO.save(funcionario);
	}
	
	public void delete(Long id) {
		funcionarioDAO.deleteById(id);
	}
}