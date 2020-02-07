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
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 20)
	private String nome;
	
	@NotNull
	@Size(max = 20)
	private String sobrenome;
	
	@NotNull
	@Column(name = "data_contratacao")
	@Size(max = 10)
	private String dataContratacao;
	
	@NotNull
	@Size(max = 15)
	private String tipo;
	
	@NotNull
	@Column(name = "local_de_trabalho")
	@Size(max = 20)
	private String nomeLocalDeTrabalho;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeLocalDeTrabalho() {
		return nomeLocalDeTrabalho;
	}

	public void setNomeLocalDeTrabalho(String nomeLocalDeTrabalho) {
		this.nomeLocalDeTrabalho = nomeLocalDeTrabalho;
	}
	
	
}