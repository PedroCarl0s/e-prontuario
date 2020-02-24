package com.riotinto.prontuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riotinto.prontuario.model.Prontuario;
import com.riotinto.prontuario.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

	@Autowired
	private ProntuarioRepository prontuarioDAO;
	
	
	public List<Prontuario> findAll() {
		return prontuarioDAO.findAll();
	}
	
	public Optional<Prontuario> findById(Long id) {
		return prontuarioDAO.findById(id);
	}
	
	public Optional<Prontuario> findByNomePacienteAndQueixaPrincipal(String nome, String queixa) {
		return prontuarioDAO.findByNomePacienteAndQueixaPrincipal(nome, queixa);
	}
	
	public Prontuario save(Prontuario prontuario) {
		return prontuarioDAO.save(prontuario);
	}
	
	public void delete(Long id) {
		prontuarioDAO.deleteById(id);
	}
	
}