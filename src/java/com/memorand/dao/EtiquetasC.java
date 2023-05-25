package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class EtiquetasC implements Serializable
{
    private int idEtiquetaC;
    private String nomEtiquetaC;

    public EtiquetasC() {
    }
    
    public EtiquetasC(int idEtiquetaC) 
    {
        this.idEtiquetaC = idEtiquetaC;
    }

    public int getIdEtiquetaC() {
        return idEtiquetaC;
    }

    public void setIdEtiquetaC(int idEtiquetaC) {
        this.idEtiquetaC = idEtiquetaC;
    }

    public String getNomEtiquetaC() {
        return nomEtiquetaC;
    }

    public void setNomEtiquetaC(String nomEtiquetaC) {
        this.nomEtiquetaC = nomEtiquetaC;
    }
    
    
}
