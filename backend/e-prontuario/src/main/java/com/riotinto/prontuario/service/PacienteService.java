package com.riotinto.prontuario.service;

import java.util.List;
import java.util.Optional;

import com.riotinto.prontuario.model.Paciente;
import com.riotinto.prontuario.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteDAO;

    
    public List<Paciente> findAll() {
        return pacienteDAO.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteDAO.findById(id);
    }

    public Optional<Paciente> findByIdOrNomeAndSobrenomeAndDataNascimento(Long id, String nome, String sobrenome, String dataNascimento) {
        return pacienteDAO.findByIdOrNomeAndSobrenomeAndDataNascimento(id, nome, sobrenome, dataNascimento);
    }

    public Paciente save(Paciente paciente) {
        return pacienteDAO.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteDAO.deleteById(id);
    }
    
}