package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;
import java.util.Date;

public class PendientesC implements Serializable
{
    private int idPendC;
    private String nomPendC;
    private String subPendC;
    private String descPendC;
    private Date fechaInicioC;
    private Date fechaFinalC;
    private String colorPendC;
    private boolean completadoC;

    public PendientesC() {
    }
    
    public PendientesC(int idPendC) 
    {
        this.idPendC = idPendC;
    }

    public int getIdPendC() {
        return idPendC;
    }

    public void setIdPendC(int idPendC) {
        this.idPendC = idPendC;
    }

    public String getNomPendC() {
        return nomPendC;
    }

    public void setNomPendC(String nomPendC) {
        this.nomPendC = nomPendC;
    }

    public String getSubPendC() {
        return subPendC;
    }

    public void setSubPendC(String subPendC) {
        this.subPendC = subPendC;
    }

    public String getDescPendC() {
        return descPendC;
    }

    public void setDescPendC(String descPendC) {
        this.descPendC = descPendC;
    }

    public Date getFechaInicioC() {
        return fechaInicioC;
    }

    public void setFechaInicioC(Date fechaInicioC) {
        this.fechaInicioC = fechaInicioC;
    }

    public Date getFechaFinalC() {
        return fechaFinalC;
    }

    public void setFechaFinalC(Date fechaFinalC) {
        this.fechaFinalC = fechaFinalC;
    }

    public String getColorPendC() {
        return colorPendC;
    }

    public void setColorPendC(String colorPendC) {
        this.colorPendC = colorPendC;
    }

    public boolean isCompletadoC() {
        return completadoC;
    }

    public void setCompletadoC(boolean completadoC) {
        this.completadoC = completadoC;
    }
    
    
}
