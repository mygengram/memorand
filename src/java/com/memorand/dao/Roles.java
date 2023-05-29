package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

public class Roles implements Serializable
{
    private String rolUsuario;
    
    public Roles() {}
    
    public Roles(String rolUsuario) 
    {
        this.rolUsuario = rolUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}