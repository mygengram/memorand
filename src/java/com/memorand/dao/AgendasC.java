package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class AgendasC implements Serializable
{
    private int idAgenda;
    private String nomAgenda;
    private String descAgenda;
    private String colorAgenda;
    private String codigoAgenda;

    public AgendasC() {}
    
    public AgendasC(int idAgenda) 
    {
        this.idAgenda = idAgenda;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getNomAgenda() {
        return nomAgenda;
    }

    public void setNomAgenda(String nomAgenda) {
        this.nomAgenda = nomAgenda;
    }

    public String getDescAgenda() {
        return descAgenda;
    }

    public void setDescAgenda(String descAgenda) {
        this.descAgenda = descAgenda;
    }

    public String getColorAgenda() {
        return colorAgenda;
    }

    public void setColorAgenda(String colorAgenda) {
        this.colorAgenda = colorAgenda;
    }

    public String getCodigoAgenda() {
        return codigoAgenda;
    }

    public void setCodigoAgenda(String codigoAgenda) {
        this.codigoAgenda = codigoAgenda;
    }
    
    
}
