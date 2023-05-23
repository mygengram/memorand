package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.Usuarios;
import com.memorand.dao.service.UsuariosService;

public class UsuariosHelper extends Helpers<Usuarios> implements Serializable
{
    private UsuariosService usuariosService;
    
    public UsuariosHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNullAndNotEmpty( t.getUsuario()) &&
               isNotNullAndNotEmpty( t.getContrasena()) &&
               isNotNullAndNotEmpty( t.getNomUsuario()) &&
               isNotNullAndNotEmpty( t.getApellidoPat()) &&
               isNotNullAndNotEmpty( t.getApellidoMat()) &&
               isNotNull(t.getFechaNac());
    }

    @Override
    public boolean addT() 
    {
        usuariosService = new UsuariosService();
        t = new Usuarios();

        t.setUsuario(getParameter("user"));
        t.setContrasena(getParameter("pass"));
        t.setNomUsuario(getParameter("name"));
        t.setApellidoPat(getParameter("ap"));
        t.setApellidoMat(getParameter("am"));
        t.setFechaNac(string2Date( getParameter("fn")));
        
        if( isValidaCamposOk( ) )
        {
            return usuariosService.addUsuario(t );
        }
        return false;
    }

    @Override
    public List<Usuarios> getListT() 
    {
        usuariosService = new UsuariosService();
        return usuariosService.getUsuariosList();
    }

    @Override
    public boolean updateT() 
    {
        usuariosService = new UsuariosService();
        t = new Usuarios();
        t.setUsuario(getParameter("user"));
        t.setContrasena(getParameter("pass"));
        t.setNomUsuario(getParameter("name"));
        t.setApellidoPat(getParameter("ap"));
        t.setApellidoMat(getParameter("am"));
        t.setFechaNac(string2Date( getParameter("fn")));
        if( isValidaCamposOk( ) )
        {
            return usuariosService.updateUsuario(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() 
    {
        usuariosService = new UsuariosService();
        t = new Usuarios();
        t.setUsuario(getParameter("user"));
        if( t.getUsuario() != null || t.getUsuario().length() > 0 )
        {
            return usuariosService.deleteUsuario(t);
        }
        return false;
    }
    
    @Override
    public Usuarios getTByKey() 
    {
        String usuario = null;
        
        usuario = getParameter("user");
        if( usuario == null || usuario.length( ) <= 0 )
        {
            return null;
        }
        usuariosService = new UsuariosService();
        return usuariosService.getUsuarioByUsuario(usuario);
    }
}
