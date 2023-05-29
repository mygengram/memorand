package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class UsuariosPendientes implements Serializable
{
    private Usuarios usuario;
    private PendientesP idPendP;

    public UsuariosPendientes() {}
    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public PendientesP getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(PendientesP idPendP) {
        this.idPendP = idPendP;
    }
}
