package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Rol_Usuario implements Serializable
{
    private Usuarios usuario;
    private Roles rol;
    
    public Rol_Usuario() {}

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
