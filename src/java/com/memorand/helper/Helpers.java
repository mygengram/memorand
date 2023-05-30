package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public abstract class Helpers<T> implements Serializable 
{
    protected HttpServletRequest request;
    protected T t;
    protected List<T> list;

    public Helpers() {}
    
    public Helpers addRequest(HttpServletRequest request)
    {
        this.request = request;
        return this;
    }
    
    public String getParameter(String name)
    {
        if( request == null || name == null ) {
            return null;
        }
        if( name.length() <0 ) {
            return null;
        }
        return request.getParameter(name);
    }
    
    public abstract boolean addT();
    public abstract List<T> getListT();
    public abstract boolean updateT();
    public abstract boolean deleteT();
    public abstract T getTByKey();
    
    public boolean isNullOrEmpty(String valor)
    {
        return (valor == null || valor.length() <= 0);
    }
    
    public boolean isNotNullAndNotEmpty(String valor)
    {
        return (valor != null && valor.length() > 0);
    }

    public boolean isNotNull(Object valor)
    {
        return (valor != null);
    }
    
    public String codigoAleatorio6() {
        String Caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int Longitud = 6;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(Longitud);

        for (int i = 0; i < Longitud; i++) {
            int randomIndex = random.nextInt(Caracteres.length());
            char randomChar = Caracteres.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    
    public String codigoAleatorio12() {
        String Caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int Longitud = 12;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(Longitud);

        for (int i = 0; i < Longitud; i++) {
            int randomIndex = random.nextInt(Caracteres.length());
            char randomChar = Caracteres.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
