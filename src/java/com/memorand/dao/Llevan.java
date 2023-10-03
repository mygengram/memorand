package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Llevan implements Serializable
{
    private String idLlevan;
    private String usuario;
    private String idAgenda;
    private String rolAgenda;
    private String favorito;

    public Llevan() {
    }

    public String getIdLlevan() {
        return idLlevan;
    }

    public void setIdLlevan(String idLlevan) {
        this.idLlevan = idLlevan;
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
