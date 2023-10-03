package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class UsuariosPendientes implements Serializable
{
    private String usuario;
    private String idPendP;

    public UsuariosPendientes() {}
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario.getUsuario();
    }

    public String getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(PendientesP idPendP) {
        this.idPendP = idPendP.getIdPendP();
    }
}
