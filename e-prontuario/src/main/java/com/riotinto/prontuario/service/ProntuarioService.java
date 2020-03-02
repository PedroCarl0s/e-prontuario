package com.riotinto.prontuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riotinto.prontuario.model.Paciente;
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
	
	public Optional<Prontuario> findByPacienteAndData(Paciente paciente, String data) {
		return prontuarioDAO.findByPacienteAndData(paciente, data);
	}
	
	public Prontuario save(Prontuario prontuario) {
		return prontuarioDAO.save(prontuario);
	}
	
	public void delete(Long id) {
		prontuarioDAO.deleteById(id);
	}
	
	public boolean validateWeightAndHeight(double weight, double height) {
		return (weight > 0 && height > 0);
	}

}