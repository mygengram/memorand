package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class AgendaEtiquetas implements Serializable
{
    private AgendasC idAgenda;
    private EtiquetasC idEtiquetaC;

    public AgendaEtiquetas() {}

    public AgendasC getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(AgendasC idAgenda) {
        this.idAgenda = idAgenda;
    }

    public EtiquetasC getIdEtiquetaC() {
        return idEtiquetaC;
    }

    public void setIdEtiquetaC(EtiquetasC idEtiquetaC) {
        this.idEtiquetaC = idEtiquetaC;
    }
}
