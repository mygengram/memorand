package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.InputStream;
import java.io.Serializable;

// CLASE
public class AgendasC implements Serializable
{
    public AgendasC() {}
    
    private int idAgenda;
    private String nomAgenda;
    private String descAgenda;
    private InputStream iconoAgendaI;
    private byte[] iconoAgendaB;
    private String colorAgenda;

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

    public InputStream getIconoAgendaI() {
        return iconoAgendaI;
    }

    public void setIconoAgendaI(InputStream iconoAgendaI) {
        this.iconoAgendaI = iconoAgendaI;
    }

    public byte[] getIconoAgendaB() {
        return iconoAgendaB;
    }

    public void setIconoAgendaB(byte[] iconoAgendaB) {
        this.iconoAgendaB = iconoAgendaB;
    }

    public String getColorAgenda() {
        return colorAgenda;
    }

    public void setColorAgenda(String colorAgenda) {
        this.colorAgenda = colorAgenda;
    }
    
    
}
