package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class UsuariosEtiquetas implements Serializable
{
    private Usuarios usuario;
    private EtiquetasP idEtiquetaP;

    public UsuariosEtiquetas() {
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public EtiquetasP getIdEtiquetaP() {
        return idEtiquetaP;
    }

    public void setIdEtiquetaP(EtiquetasP idEtiquetaP) {
        this.idEtiquetaP = idEtiquetaP;
    }
    
}
