package com.riotinto.prontuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.riotinto.prontuario.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

	Optional<Medico> findByCrm(String crm);
}