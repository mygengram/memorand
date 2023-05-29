package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Llevan implements Serializable
{
    private int idLlevan;
    private Usuarios usuario;
    private AgendasC idAgenda;
    private String rolAgenda;
    private String favorito;

    public Llevan() {
    }

    public int getIdLlevan() {
        return idLlevan;
    }

    public void setIdLlevan(int idLlevan) {
        this.idLlevan = idLlevan;
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

    public String getRolAgenda() {
        return rolAgenda;
    }

    public void setRolAgenda(String rolAgenda) {
        this.rolAgenda = rolAgenda;
    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }
}
