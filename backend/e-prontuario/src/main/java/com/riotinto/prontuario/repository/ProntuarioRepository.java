package com.riotinto.prontuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riotinto.prontuario.model.Medico;
import com.riotinto.prontuario.model.Paciente;
import com.riotinto.prontuario.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long>{
	
	Optional<Prontuario> findByPacienteAndDataAndMedico(Paciente paciente, String data, Medico medico);
}