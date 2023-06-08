package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class AgendasC implements Serializable
{
    private String idAgenda;
    private String nomAgenda;
    private String descAgenda;
    private String codigoAgenda;

    public AgendasC() {}
    
    public AgendasC(String idAgenda) 
    {
        this.idAgenda = idAgenda;
    }

    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(String idAgenda) {
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

    public String getCodigoAgenda() {
        return codigoAgenda;
    }

    public void setCodigoAgenda(String codigoAgenda) {
        this.codigoAgenda = codigoAgenda;
    }
}
