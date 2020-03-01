package com.riotinto.prontuario.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "pacientes")
public class Paciente {
	
	@ApiModelProperty(notes = "Identificador do paciente", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome do paciente", name = "nome", required = true)
	@NotNull
	@Size(max = 20)
	private String nome;
	
	@ApiModelProperty(notes = "Sobrenome do paciente", name = "sobrenome", required = true)
	@NotNull
	@Size(max = 20)
	private String sobrenome;
	
	@ApiModelProperty(notes = "Data de nascimento", name = "data_nascimento", required = true, value = "yyyy-mm-dd")
	@NotNull
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@ApiModelProperty(notes = "Idade do paciente", name = "idade", required = true)
	@NotNull
	private Long idade;
	
	@ApiModelProperty(notes = "Naturalidade do paciente", name = "naturalidade", required = true)
	@NotNull
	@Size(max = 35)
	private String naturalidade;
	
	@ApiModelProperty(notes = "Procedência do paciente", name = "procedencia", required = true)
	@NotNull
	@Size(max = 30)
	private String procedencia;

	@ApiModelProperty(notes = "Profissão do paciente", name = "profissao", required = true)
	@NotNull
	@Size(max = 30)
	private String profissao;
	
	@ApiModelProperty(notes = "Nome da mãe", name = "nome_mae", required = true)
	@NotNull
	@Size(max = 35)
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paciente", orphanRemoval = true)
	private List<Prontuario> prontuarios = new ArrayList<>();

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Endereco endereco;
	
	
	public Paciente() {
		super();
	}

	public Paciente(Long id, @NotNull @Size(max = 20) final String nome, @NotNull @Size(max = 20) final String sobrenome,
			@NotNull final String dataNascimento, @NotNull final Long idade, @NotNull @Size(max = 35) final String naturalidade,
			@NotNull @Size(max = 30) final String procedencia, @NotNull @Size(max = 30) final String profissao,
			@NotNull @Size(max = 35) final String nomeMae, final Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.naturalidade = naturalidade;
		this.procedencia = procedencia;
		this.profissao = profissao;
		this.nomeMae = nomeMae;
		this.endereco = endereco;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	public List<Prontuario> getProntuarios() {
		return this.prontuarios;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}