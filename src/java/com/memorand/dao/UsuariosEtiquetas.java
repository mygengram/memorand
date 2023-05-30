package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class UsuariosEtiquetas implements Serializable
{
    private String usuario;
    private String idEtiquetaP;

    public UsuariosEtiquetas() {}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario.getUsuario();
    }

    public String getIdEtiquetaP() {
        return idEtiquetaP;
    }

    public void setIdEtiquetaP(EtiquetasP idEtiquetaP) {
        this.idEtiquetaP = idEtiquetaP.getIdEtiquetaP();
    }
}
