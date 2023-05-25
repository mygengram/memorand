package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Tienen implements Serializable
{
    private int idTienen;
    private Usuarios usuario;
    private AgendasC idAgenda;
    private PendientesC idPendC;
    private String autor;

    public Tienen() {
    }
    
    public Tienen(int idTienen) 
    {
        this.idTienen = idTienen;
    }

    public int getIdTienen() {
        return idTienen;
    }

    public void setIdTienen(int idTienen) {
        this.idTienen = idTienen;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public AgendasC getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(AgendasC idAgenda) {
        this.idAgenda = idAgenda;
    }

    public PendientesC getIdPendC() {
        return idPendC;
    }

    public void setIdPendC(PendientesC idPendC) {
        this.idPendC = idPendC;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
