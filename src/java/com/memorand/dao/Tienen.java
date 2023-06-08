package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Tienen implements Serializable
{
    private String idTienen;
    private String usuario;
    private String idAgenda;
    private String idPendC;
    private String autor;

    public Tienen() {}
    
    public Tienen(String idTienen) 
    {
        this.idTienen = idTienen;
    }

    public String getIdTienen() {
        return idTienen;
    }

    public void setIdTienen(String idTienen) {
        this.idTienen = idTienen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario.getUsuario();
    }

    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(AgendasC idAgenda) {
        this.idAgenda = idAgenda.getIdAgenda();
    }

    public String getIdPendC() {
        return idPendC;
    }

    public void setIdPendC(PendientesC idPendC) {
        this.idPendC = idPendC.getIdPendC();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
