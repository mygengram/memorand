package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;

// CLASE
public class Usuarios implements Serializable
{
    public Usuarios() {}
    
    private String username;
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
