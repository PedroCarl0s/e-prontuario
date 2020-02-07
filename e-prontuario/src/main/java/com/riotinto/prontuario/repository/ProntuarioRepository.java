package com.riotinto.prontuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riotinto.prontuario.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long>{
	
	Optional<Prontuario> findByIdAndNomePacienteAndQueixaPrincipal(Long id, String nomePaciente, String queixaPrincipal);
}