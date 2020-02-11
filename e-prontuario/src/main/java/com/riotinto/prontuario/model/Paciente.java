package com.riotinto.prontuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "pacientes")
public class Paciente {
	
	@ApiModelProperty(notes = "Identificador do paciente", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Nome do paciente", name = "nome", required = true)
	@NotEmpty
	@Size(max = 20)
	private String nome;
	
	@ApiModelProperty(notes = "Sobrenome do paciente", name = "sobrenome", required = true)
	@NotEmpty
	@Size(max = 20)
	private String sobrenome;
	
	@ApiModelProperty(notes = "Data de nascimento", name = "data_nascimento", required = true, value = "yyyy-mm-dd")
	@NotEmpty
	@Column(name = "data_nascimento")
	private String dataNascimento;
	
	@ApiModelProperty(notes = "Idade do paciente", name = "idade", required = true)
	@NotNull
	@Min(1)
	private int idade;
	
	@ApiModelProperty(notes = "Naturalidade do paciente", name = "naturalidade", required = true)
	@NotEmpty
	@Size(max = 25)
	private String naturalidade;
	
	@ApiModelProperty(notes = "Procedência do paciente", name = "procedencia", required = true)
	@NotEmpty
	@Size(max = 30)
	private String procedencia;

	@ApiModelProperty(notes = "Profissão do paciente", name = "profissao", required = true)
	@NotEmpty
	@Size(max = 30)
	private String profissao;
	
	@ApiModelProperty(notes = "Nome da mãe", name = "nome_mae", required = true)
	@NotEmpty
	@Size(max = 35)
	@Column(name = "nome_mae")
	private String nomeMae;
	
	
	
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}