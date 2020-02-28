package com.riotinto.prontuario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sintomas")
public class Sintoma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 150)
    private String geral;

    @Size(max = 150)
    private String pele;

    @Size(max = 150)
    private String cabeca_e_pescoco;    

    @Size(max = 350)
    private String face_olhos_ouvidos_boca;

    @Size(max = 350)
    private String ap_cardiovascular;

    @Size(max = 350)
    private String ap_respiratorio;

    @Size(max = 350)
    private String ap_digestivo;

    @Size(max = 350)
    private String ap_genito_urinario;

    @Size(max = 350)
    private String ap_musculo_esqueletico;

    @Size(max = 350)
    private String ap_sist_nervoso_psiquismo;

    @JsonIgnore
    @OneToOne(mappedBy = "sintoma")
    private Prontuario prontuario;

    
    public Sintoma() {
        super();
    }

    public Sintoma(Long id, @Size(max = 150) String geral, @Size(max = 150) String pele,
            @Size(max = 150) String cabeca_e_pescoco, @Size(max = 350) String face_olhos_ouvidos_boca,
            @Size(max = 350) String ap_cardiovascular, @Size(max = 350) String ap_respiratorio,
            @Size(max = 350) String ap_digestivo, @Size(max = 350) String ap_genito_urinario,
            @Size(max = 350) String ap_musculo_esqueletico, @Size(max = 350) String ap_sist_nervoso_psiquismo,
            Prontuario prontuario) {
        this.id = id;
        this.geral = geral;
        this.pele = pele;
        this.cabeca_e_pescoco = cabeca_e_pescoco;
        this.face_olhos_ouvidos_boca = face_olhos_ouvidos_boca;
        this.ap_cardiovascular = ap_cardiovascular;
        this.ap_respiratorio = ap_respiratorio;
        this.ap_digestivo = ap_digestivo;
        this.ap_genito_urinario = ap_genito_urinario;
        this.ap_musculo_esqueletico = ap_musculo_esqueletico;
        this.ap_sist_nervoso_psiquismo = ap_sist_nervoso_psiquismo;
        this.prontuario = prontuario;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeral() {
        return geral;
    }

    public void setGeral(String geral) {
        this.geral = geral;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getCabeca_e_pescoco() {
        return cabeca_e_pescoco;
    }

    public void setCabeca_e_pescoco(String cabeca_e_pescoco) {
        this.cabeca_e_pescoco = cabeca_e_pescoco;
    }

    public String getFace_olhos_ouvidos_boca() {
        return face_olhos_ouvidos_boca;
    }

    public void setFace_olhos_ouvidos_boca(String face_olhos_ouvidos_boca) {
        this.face_olhos_ouvidos_boca = face_olhos_ouvidos_boca;
    }

    public String getAp_cardiovascular() {
        return ap_cardiovascular;
    }

    public void setAp_cardiovascular(String ap_cardiovascular) {
        this.ap_cardiovascular = ap_cardiovascular;
    }

    public String getAp_respiratorio() {
        return ap_respiratorio;
    }

    public void setAp_respiratorio(String ap_respiratorio) {
        this.ap_respiratorio = ap_respiratorio;
    }

    public String getAp_digestivo() {
        return ap_digestivo;
    }

    public void setAp_digestivo(String ap_digestivo) {
        this.ap_digestivo = ap_digestivo;
    }

    public String getAp_genito_urinario() {
        return ap_genito_urinario;
    }

    public void setAp_genito_urinario(String ap_genito_urinario) {
        this.ap_genito_urinario = ap_genito_urinario;
    }

    public String getAp_musculo_esqueletico() {
        return ap_musculo_esqueletico;
    }

    public void setAp_musculo_esqueletico(String ap_musculo_esqueletico) {
        this.ap_musculo_esqueletico = ap_musculo_esqueletico;
    }

    public String getAp_sist_nervoso_psiquismo() {
        return ap_sist_nervoso_psiquismo;
    }

    public void setAp_sist_nervoso_psiquismo(String ap_sist_nervoso_psiquismo) {
        this.ap_sist_nervoso_psiquismo = ap_sist_nervoso_psiquismo;
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
        Sintoma other = (Sintoma) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}