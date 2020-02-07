package com.riotinto.prontuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "prontuarios")
public class Prontuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "nome_paciente")
	private String nomePaciente;
	
	@NotNull
	@Size(max = 30)
	@Column(name = "queixa_principal")
	private String queixaPrincipal;
	
	@NotNull
	@Size(max = 40)
	@Column(name = "historia_doenca_atual")
	private String historiaDoencaAtual;
	
	@NotNull
	@Size(max = 60)
	@Column(name = "interrogatorio_sintomatoligico")
	private String interrogatorioSintomatoligico;
	
	@NotNull
	@Size(max = 70)
	@Column(name = "exame_fisico")
	private String exameFisico;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "evolucoes")
	private String evolucoes;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getQueixaPrincipal() {
		return queixaPrincipal;
	}

	public void setQueixaPrincipal(String queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}

	public String getHistoriaDoencaAtual() {
		return historiaDoencaAtual;
	}

	public void setHistoriaDoencaAtual(String historiaDoencaAtual) {
		this.historiaDoencaAtual = historiaDoencaAtual;
	}

	public String getInterrogatorioSintomatoligico() {
		return interrogatorioSintomatoligico;
	}

	public void setInterrogatorioSintomatoligico(String interrogatorioSintomatoligico) {
		this.interrogatorioSintomatoligico = interrogatorioSintomatoligico;
	}

	public String getExameFisico() {
		return exameFisico;
	}

	public void setExameFisico(String exameFisico) {
		this.exameFisico = exameFisico;
	}

	public String getEvolucoes() {
		return evolucoes;
	}

	public void setEvolucoes(String evolucoes) {
		this.evolucoes = evolucoes;
	}
	
	
	
}