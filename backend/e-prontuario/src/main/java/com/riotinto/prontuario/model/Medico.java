package com.riotinto.prontuario.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "medicos")
public class Medico {

    @ApiModelProperty(notes = "Identificador do médico", name = "id", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Nome do médico", name = "nome", required = true)
	@NotNull
	@Size(max = 20)
	private String nome;

	@ApiModelProperty(notes = "Sobrenome do médico", name = "sobrenome", required = true)
	@NotNull
	@Size(max = 20)
	private String sobrenome;

	@ApiModelProperty(notes = "CRM do médico", name = "crm", required = true)
	@NotNull
	@Size(min = 1, max = 10)
	private String crm;

	@ApiModelProperty(notes = "UF do médico", name = "uf", required = true, allowableValues = "AC,AL,AP,AM,BA,CE,DF,ES,GO,MA,MT,MS,MG,PA,PB,PR,PE,PI,RJ,RN,RS,RO,RR,SC,SP,SE,TO")
	@NotNull
	@Size(min = 2, max = 2)
	private String uf;

	@ApiModelProperty(notes = "Município do médico", name = "municipio", required = true)
	@NotNull
	@Size(min = 4, max = 30)
	private String municipio;

    
	@ApiModelProperty(notes = "Situação do médico (ativo ou inativo)", name = "crm", required = true, allowableValues = "0, 1")
    @NotNull
    @Size(min = 1, max = 1)
    private String status;
    
    @JsonIgnore
    @OneToMany(mappedBy = "medico", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Prontuario> prontuarios = new ArrayList<>();


    public Medico() {}

    public Medico(@NotNull @Size(max = 20) String nome, @NotNull @Size(max = 20) String sobrenome,
            @NotNull @Size(min = 1, max = 10) String crm, @NotNull @Size(min = 2, max = 2) String uf,
            @NotNull @Size(min = 4, max = 30) String municipio, @NotNull @Size(min = 1, max = 1) String status) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.crm = crm;
        this.uf = uf;
        this.municipio = municipio;
        this.status = status;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
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
        Medico other = (Medico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}