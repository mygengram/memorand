package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

// CLASE
public class Usuarios implements Serializable
{
    public Usuarios() {}
    
    private int idUsuario;
    private String usuario;
    private String contrasena;
    private String nomUsuario;
    private String apellidoPat;
    private String apellidoMat;
    private Date fechaNac;
    private InputStream imgUsuarioI;
    private byte[] imgUsuarioB;
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public InputStream getImgUsuarioI() {
        return imgUsuarioI;
    }

    public void setImgUsuarioI(InputStream imgUsuarioI) {
        this.imgUsuarioI = imgUsuarioI;
    }

    public byte[] getImgUsuarioB() {
        return imgUsuarioB;
    }

    public void setImgUsuarioB(byte[] imgUsuarioB) {
        this.imgUsuarioB = imgUsuarioB;
    }
}
