package com.riotinto.prontuario.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enderecos")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 40)
	private String rua;
	
	@NotNull
	@Size(max = 40)
	private String bairro;
	
	@Min(1)
	private int numero;
	
	@JsonIgnore
	@OneToOne(mappedBy = "endereco")
	private Paciente paciente;

	
	public Endereco() {
		super();
	}

	public Endereco(@NotNull @Size(max = 40) String rua, @NotNull @Size(max = 40) String bairro,
			@Min(1) int numero, Paciente paciente) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.paciente = paciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}