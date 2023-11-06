package com.gengram.dao;

import java.io.Serializable;

public class Usuarios implements Serializable {

    private String id_usuario;
    private String correo_usuario;
    private String pass_usuario;
    private String tipo_usuario;
    private String nombre_usuario;
    private String paterno_usuario;
    private String materno_usuario;

    public Usuarios() {}

    public Usuarios(String id_usuario, String correo_usuario, String pass_usuario, String tipo_usuario, String nombre_usuario, String paterno_usuario, String materno_usuario) {
        this.id_usuario = id_usuario;
        this.correo_usuario = correo_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.paterno_usuario = paterno_usuario;
        this.materno_usuario = materno_usuario;
    }

    public Usuarios(String correo_usuario, String pass_usuario, String tipo_usuario, String nombre_usuario, String paterno_usuario, String materno_usuario) {
        this.correo_usuario = correo_usuario;
        this.pass_usuario = pass_usuario;
        this.tipo_usuario = tipo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.paterno_usuario = paterno_usuario;
        this.materno_usuario = materno_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo_usuario() {
        return correo_usuario;
    }

    public void setCorreo_usuario(String correo_usuario) {
        this.correo_usuario = correo_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPaterno_usuario() {
        return paterno_usuario;
    }

    public void setPaterno_usuario(String paterno_usuario) {
        this.paterno_usuario = paterno_usuario;
    }

    public String getMaterno_usuario() {
        return materno_usuario;
    }

    public void setMaterno_usuario(String materno_usuario) {
        this.materno_usuario = materno_usuario;
    }

}
