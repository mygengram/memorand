package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

// CLASE
public class Favoritos implements Serializable
{
    public Favoritos() {}
    
    private int idFavorito;
    private String estadoFavorito;

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public String getEstadoFavorito() {
        return estadoFavorito;
    }

    public void setEstadoFavorito(String estadoFavorito) {
        this.estadoFavorito = estadoFavorito;
    }
}
