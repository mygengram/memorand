package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public abstract class Helpers<T> implements Serializable 
{
    protected HttpServletRequest request;
    protected T t;
    protected List<T> list;

    public Helpers() {}
    
    public Helpers addRequest( HttpServletRequest request )
    {
        this.request = request;
        return this;
    }
    
    public String getParameter( String name )
    {
        if( request == null || name == null )
        {
            return null;
        }
        if( name.length() <0 )
        {
            return null;
        }
        return request.getParameter( name );
    }
    
    public abstract boolean addT( );
    public abstract List<T> getListT( );
    public abstract boolean updateT( );
    public abstract boolean deleteT( );
    public abstract T getTByKey( );
    
    public boolean isNullOrEmpty( String valor )
    {
        return valor == null || valor.length() <= 0;
    }
    
    public boolean isNotNullAndNotEmpty( String valor )
    {
        return valor != null && valor.length() > 0;
    }

    public boolean isNotNull( Object valor )
    {
        return valor != null;
    }
    
    public static Date string2Date (String fecha) {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaDate = formatoEntrada.parse(fecha);
            return fechaDate;
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            return null;
        }
    }
    
    public static String date2String(Date fecha) {
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formatoSalida.format(fecha);
        return fechaString;
    }
}
