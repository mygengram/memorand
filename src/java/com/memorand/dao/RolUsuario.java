package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class RolUsuario implements Serializable
{
    private String usuario;
    private String rol;
    
    public RolUsuario() {}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario.getUsuario();
    }

    public String getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol.getRolUsuario();
    }
}
