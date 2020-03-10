package com.riotinto.prontuario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "exames_fisicos")
public class ExameFisico {

    @ApiModelProperty(notes = "Identificador do exame físico", name = "id", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Peso em kg do paciente", name = "peso", required = true)
    @NotNull
    private double peso;

    @ApiModelProperty(notes = "Altura em metros do paciente", name = "altura", required = true)
    @NotNull
    private double altura;

    @ApiModelProperty(notes = "Índice de Massa Corporal do paciente (kg / m²)", name = "imc")
    @NotEmpty
    private String imc;

    @ApiModelProperty(notes = "Estado da pele do paciente", name = "pele", required = true)
    @NotNull
    @Size(max = 150)
    private String pele;

    @ApiModelProperty(notes = "Ausculta Cardiovascular", name = "ACV", required = true)
    @NotNull
    @Size(max = 150)
    @Column(name = "ausculta_cardiovascular")
    private String auscultaCardiovascular;

    @ApiModelProperty(notes = "Ausculta Respiratoria", name = "AR", required = true)
    @NotNull
    @Size(max = 150)
    @Column(name = "ausculta_respiratoria")
    private String auscultaRespiratoria;

    @ApiModelProperty(notes = "Extremidades", name = "extremidades", required = true)
    @NotNull
    @Size(max = 150)                            
    private String extremidades;

    @ApiModelProperty(notes = "Hipótese Diagnóstica", name = "HD", required = true)
    @NotNull
    @Size(max = 150)                            
    @Column(name = "hipotese_diagnostica")
    private String hipoteseDiagnostica;

    @ApiModelProperty(notes = "Conduta", name = "conduta", required = true)
    @NotNull
    @Size(max = 400)
    private String conduta;

    @ApiModelProperty(notes = "Evoluções", name = "evolucoes", required = true)
    @NotNull
    @Size(max = 700)
    private String evolucoes;
    
    @JsonIgnore
    @OneToOne(mappedBy = "exameFisico")
    private Prontuario prontuario;

    
    public ExameFisico() {}
    
    public ExameFisico(@NotNull double peso, @NotNull double altura,
            @NotNull @Size(max = 150) String pele, @NotNull @Size(max = 150) String auscultaCardiovascular,
            @NotNull @Size(max = 150) String auscultaRespiratoria, @NotNull @Size(max = 150) String extremidades,
            @NotNull @Size(max = 150) String hipoteseDiagnostica, @NotNull @Size(max = 400) String conduta,
            @NotNull @Size(max = 700) String evolucoes, Prontuario prontuario) {
        this.peso = peso;
        this.altura = altura;
        setImc(peso, altura);
        this.pele = pele;
        this.auscultaCardiovascular = auscultaCardiovascular;
        this.auscultaRespiratoria = auscultaRespiratoria;
        this.extremidades = extremidades;
        this.hipoteseDiagnostica = hipoteseDiagnostica;
        this.conduta = conduta;
        this.evolucoes = evolucoes;
        this.prontuario = prontuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(double peso, double altura) {
        double res =  (peso / (altura * altura));
        this.imc = String.format("%.2f", res);
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getAuscultaCardiovascular() {
        return auscultaCardiovascular;
    }

    public void setAuscultaCardiovascular(String auscultaCardiovascular) {
        this.auscultaCardiovascular = auscultaCardiovascular;
    }

    public String getAuscultaRespiratoria() {
        return auscultaRespiratoria;
    }

    public void setAuscultaRespiratoria(String auscultaRespiratoria) {
        this.auscultaRespiratoria = auscultaRespiratoria;
    }

    public String getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    public String getHipoteseDiagnostica() {
        return hipoteseDiagnostica;
    }

    public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
        this.hipoteseDiagnostica = hipoteseDiagnostica;
    }

    public String getConduta() {
        return conduta;
    }

    public void setConduta(String conduta) {
        this.conduta = conduta;
    }

    public String getEvolucoes() {
        return evolucoes;
    }

    public void setEvolucoes(String evolucoes) {
        this.evolucoes = evolucoes;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
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
        ExameFisico other = (ExameFisico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}