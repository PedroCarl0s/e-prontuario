package com.riotinto.prontuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "prontuarios")
public class Prontuario {

	@ApiModelProperty(notes = "Identificador do prontuário", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome do paciente", name = "nome_paciente", required = true)
	@NotNull
	@Size(max = 30)
	@Column(name = "nome_paciente")
	private String nomePaciente;

	@ApiModelProperty(notes = "Data de preenchimento", name = "data", required = true, value = "yyyy-mm-dd")
	@NotNull
	@Size(max = 10)
	private String data;
	
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}