package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class PendientesP implements Serializable
{
    private Integer idPendP;
    private String nomPendP;
    private String subPendP;
    private String descPendP;
    private String fechaFinalP;
    private String completadoP;

    public PendientesP() {}
    
    public PendientesP(int idPendP) 
    {
        this.idPendP = idPendP;
    }

    public Integer getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(Integer idPendP) {
        this.idPendP = idPendP;
    }

    public String getNomPendP() {
        return nomPendP;
    }

    public void setNomPendP(String nomPendP) {
        this.nomPendP = nomPendP;
    }

    public String getSubPendP() {
        return subPendP;
    }

    public void setSubPendP(String subPendP) {
        this.subPendP = subPendP;
    }

    public String getDescPendP() {
        return descPendP;
    }

    public void setDescPendP(String descPendP) {
        this.descPendP = descPendP;
    }

    public String getFechaFinalP() {
        return fechaFinalP;
    }

    public void setFechaFinalP(String fechaFinalP) {
        this.fechaFinalP = fechaFinalP;
    }

    public String getCompletadoP() {
        return completadoP;
    }

    public void setCompletadoP(String completadoP) {
        this.completadoP = completadoP;
    }
}
