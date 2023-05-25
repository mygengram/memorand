package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class EtiquetasP implements Serializable
{
    private int idEtiquetaP;
    private String nomEtiquetaP;

    public EtiquetasP() {
    }
    
    public EtiquetasP(int idEtiquetaP) 
    {
        this.idEtiquetaP = idEtiquetaP;
    }

    public int getIdEtiquetaP() {
        return idEtiquetaP;
    }

    public void setIdEtiquetaP(int idEtiquetaP) {
        this.idEtiquetaP = idEtiquetaP;
    }

    public String getNomEtiquetaP() {
        return nomEtiquetaP;
    }

    public void setNomEtiquetaP(String nomEtiquetaP) {
        this.nomEtiquetaP = nomEtiquetaP;
    }
    
    
}
