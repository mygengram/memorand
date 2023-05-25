package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;
import java.util.Date;

public class PendientesP implements Serializable
{
    private Integer idPendP;
    private String nomPendP;
    private String subPendP;
    private String descPendP;
    private Date fechaInicioP;
    private Date fechaFinalP;
    private String colorPendP;
    private boolean completadoP;

    public PendientesP() {
    }
    
    public PendientesP(int idPendP) 
    {
        this.idPendP = idPendP;
    }

    public int getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(int idPendP) {
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

    public Date getFechaInicioP() {
        return fechaInicioP;
    }

    public void setFechaInicioP(Date fechaInicioP) {
        this.fechaInicioP = fechaInicioP;
    }

    public Date getFechaFinalP() {
        return fechaFinalP;
    }

    public void setFehcFinalP(Date fechaFinalP) {
        this.fechaFinalP = fechaFinalP;
    }

    public String getColorPendP() {
        return colorPendP;
    }

    public void setColorPendP(String colorPendP) {
        this.colorPendP = colorPendP;
    }

    public boolean isCompletadoP() {
        return completadoP;
    }

    public void setCompletadoP(boolean completadoP) {
        this.completadoP = completadoP;
    }
    
}
