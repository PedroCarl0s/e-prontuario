package com.riotinto.prontuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riotinto.prontuario.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Optional<Funcionario> findByNomeAndSobrenomeAndTipo(String nome, String sobrenome, String tipo);
}