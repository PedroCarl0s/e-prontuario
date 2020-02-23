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
@Table(name = "funcionarios")
public class Funcionario {

	@ApiModelProperty(notes = "Identificador do funcionário", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome do funcionário", name = "nome", required = true)
	@NotNull
	@Size(max = 20)
	private String nome;
	
	@ApiModelProperty(notes = "Sobrenome do funcionário", name = "sobrenome", required = true)
	@NotNull
	@Size(max = 20)
	private String sobrenome;
	
	@ApiModelProperty(notes = "Data da contratação (yyyy-mm-dd)", name = "data_contratacao", required = true, value = "yyyy-mm-dd")
	@NotNull
	@Column(name = "data_contratacao")
	@Size(max = 10)
	private String dataContratacao;
	
	@ApiModelProperty(notes = "Tipo de funcionário", name = "tipo", required = true, allowableValues = "Médico, Enfermeiro, Atendente")
	@NotNull
	@Size(max = 15)
	private String tipo;
	
	@ApiModelProperty(notes = "Nome do local de trabalho", name = "local_de_trabalho", required = true, allowableValues = "PSF, Hospital")
	@NotNull
	@Column(name = "local_de_trabalho")
	@Size(max = 20)
	private String nomeLocalDeTrabalho;

	
	public Funcionario() {
		super();
	}

	public Funcionario(Long id, @NotNull @Size(max = 20) String nome, @NotNull @Size(max = 20) String sobrenome,
			@NotNull @Size(max = 10) String dataContratacao, @NotNull @Size(max = 15) String tipo,
			@NotNull @Size(max = 20) String nomeLocalDeTrabalho) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataContratacao = dataContratacao;
		this.tipo = tipo;
		this.nomeLocalDeTrabalho = nomeLocalDeTrabalho;
	}

	
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