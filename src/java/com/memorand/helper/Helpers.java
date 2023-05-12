package com.memorand.helper;
// Memorand by Gengram © 2023 - Original by gerdoc (Germán Gutiérrez Galán).

// IMPORTACIONES
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public abstract class Helpers<T> implements Serializable 
{
    protected HttpServletRequest request;
    protected T t;
    protected List<T> list;

    public Helpers() 
    {
    }
    
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
    
    public boolean isNullOrEmpity( String valor )
    {
        return valor == null || valor.length() <= 0;
    }
    
    public boolean isNotNullAndNotEmpity( String valor )
    {
        return valor != null && valor.length() > 0;
    }
}
