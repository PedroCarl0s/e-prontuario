package com.riotinto.prontuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riotinto.prontuario.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	Optional<Paciente> findByIdOrNomeAndSobrenomeAndDataNascimento(Long id, String nome, String sobrenome, String dataNascimento);
}