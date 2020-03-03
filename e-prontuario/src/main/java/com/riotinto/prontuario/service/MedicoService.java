package com.riotinto.prontuario.service;

import java.util.List;
import java.util.Optional;

import com.riotinto.prontuario.model.Medico;
import com.riotinto.prontuario.repository.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoDAO;

    
    public List<Medico> findAll() {
        return medicoDAO.findAll();
    }

    public Optional<Medico> findById(Long id) {
        return medicoDAO.findById(id);
    }

    public Optional<Medico> findByCrm(String crm) {
        return medicoDAO.findByCrm(crm);
    }

    public Medico save(Medico medico) {
        return medicoDAO.save(medico);
    }

    public void deleteById(Long id) {
        medicoDAO.deleteById(id);
    }

}