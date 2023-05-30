package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class EtiquetasP implements Serializable
{
    private String idEtiquetaP;
    private String nomEtiquetaP;

    public EtiquetasP() {}
    
    public EtiquetasP(String idEtiquetaP) 
    {
        this.idEtiquetaP = idEtiquetaP;
    }

    public String getIdEtiquetaP() {
        return idEtiquetaP;
    }

    public void setIdEtiquetaP(String idEtiquetaP) {
        this.idEtiquetaP = idEtiquetaP;
    }

    public String getNomEtiquetaP() {
        return nomEtiquetaP;
    }

    public void setNomEtiquetaP(String nomEtiquetaP) {
        this.nomEtiquetaP = nomEtiquetaP;
    }
}
