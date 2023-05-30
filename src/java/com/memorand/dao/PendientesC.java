package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class PendientesC implements Serializable
{
    private int idPendC;
    private String nomPendC;
    private String subPendC;
    private String descPendC;
    private String fechaFinalC;
    private String completadoC;

    public PendientesC() {}
    
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

    public String getFechaFinalC() {
        return fechaFinalC;
    }

    public void setFechaFinalC(String fechaFinalC) {
        this.fechaFinalC = fechaFinalC;
    }
    
    public String getCompletadoC() {
        return completadoC;
    }

    public void setCompletadoC(String completadoC) {
        this.completadoC = completadoC;
    }
}
