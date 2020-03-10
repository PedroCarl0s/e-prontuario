package com.riotinto.prontuario.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.riotinto.prontuario.model.Medico;
import com.riotinto.prontuario.model.Paciente;
import com.riotinto.prontuario.model.Prontuario;
import com.riotinto.prontuario.service.MedicoService;
import com.riotinto.prontuario.service.PacienteService;
import com.riotinto.prontuario.service.ProntuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/api/prontuario")
@CrossOrigin(origins = "*")
@Api(value = "Prontuario", tags = { "Prontuário" })
public class ProntuarioController {

	@Autowired
	private ProntuarioService prontuarioService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private MedicoService medicoService;


	@ApiOperation(value = "Lista todos os prontuários cadastrados", produces = "application/json")
	@GetMapping
	public List<Prontuario> listar() {
		return prontuarioService.findAll();
	}
	
	@ApiOperation(value = "Busca um prontuário pelo ID", produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<Prontuario> buscar(@PathVariable("id") Long id) {
		Optional<Prontuario> prontuario = prontuarioService.findById(id);
		
		if (!prontuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(prontuario.get());
	}
	
	@ApiOperation(value = "Adiciona um prontuário", produces = "application/json")
	@PostMapping("/{idPaciente}/{idMedico}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Prontuario> adicionar(@Valid @RequestBody Prontuario prontuario, @PathVariable("idPaciente") Long idPaciente, @PathVariable("idMedico") Long idMedico) {
		
		Optional<Paciente> pacienteExistente = pacienteService.findById(idPaciente);
		Optional<Medico> medicoExistente = medicoService.findById(idMedico);

		if (!pacienteExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe um paciente com o ID " + idPaciente);
		}

		if (!medicoExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe um médico o ID " + idMedico);
		}

		Paciente paciente = pacienteExistente.get();
		Medico medico = medicoExistente.get();

		Optional<Prontuario> prontuarioExistente = prontuarioService.findByPacienteAndDataAndMedico(
				paciente, prontuario.getData(), medico);
		
		if (prontuarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Já existe um prontuário com o mesmo paciente, data e médico responsável");
		}

		boolean valoresValidos = prontuarioService.validateWeightAndHeight(prontuario.getExameFisico().getPeso(), prontuario.getExameFisico().getAltura());

		if (!valoresValidos) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
				"Peso ou altura devem ser maiores que zero!");

		prontuario.getExameFisico().setImc(prontuario.getExameFisico().getPeso(), prontuario.getExameFisico().getAltura());
		prontuario.setMedico(medico);
		prontuario.setPaciente(paciente);

		prontuarioService.save(prontuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(prontuario.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation(value = "Atualiza um prontuário", produces = "application/json")
	@PutMapping("/{id}")
	public ResponseEntity<Prontuario> atualizar(@Valid @RequestBody Prontuario prontuario, @PathVariable("id") Long id) {
		Optional<Prontuario> prontuarioExistente = prontuarioService.findById(id);
		
		if (!prontuarioExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não existe um prontuário com o ID " + id);
		}

		prontuario.setId(id);
		prontuario.setPaciente(prontuario.getPaciente());
		prontuario.getExameFisico().setId(id);
		prontuario.getExameFisico().setImc(prontuario.getExameFisico().getPeso(), prontuario.getExameFisico().getAltura());

		prontuario.getSintoma().setId(id);
		prontuarioService.save(prontuario);
		
		return ResponseEntity.ok().body(prontuario);
	}
	
	@ApiOperation(value = "Deleta um prontuário pelo ID", produces = "application/json")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletar(@PathVariable Long id ) {
		Optional<Prontuario> prontuario = prontuarioService.findById(id);
		
		if (prontuario.isPresent()) {
			prontuarioService.delete(id);
		
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Não há um prontuário com o ID " + id);
		}
		
	}
	
}