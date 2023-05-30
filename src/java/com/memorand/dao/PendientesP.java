package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class PendientesP implements Serializable
{
    private String idPendP;
    private String nomPendP;
    private String subPendP;
    private String descPendP;
    private String fechaFinalP;
    private String completadoP;

    public PendientesP() {}
    
    public PendientesP(String idPendP) 
    {
        this.idPendP = idPendP;
    }

    public String getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(String idPendP) {
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
