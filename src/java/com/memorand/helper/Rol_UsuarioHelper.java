package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.Rol_Usuario;
import com.memorand.dao.Roles;
import com.memorand.dao.Usuarios;
import com.memorand.dao.service.Rol_UsuarioService;

public class Rol_UsuarioHelper extends Helpers<Rol_Usuario> implements Serializable
{
    private Rol_UsuarioService rol_usuarioService;
    
    public Rol_UsuarioHelper() {}

    @Override
    public boolean addT() 
    {
        rol_usuarioService = new Rol_UsuarioService();
        t = new Rol_Usuario();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setRol(new Roles(getParameter("rol")));
        
        return rol_usuarioService.addRol_Usuario(t);
    }

    @Override
    public List<Rol_Usuario> getListT() 
    {
        rol_usuarioService = new Rol_UsuarioService();
        return rol_usuarioService.getRol_UsuarioList();
    }

    @Override
    public boolean updateT() 
    {
        return false;
    }

    @Override
    public boolean deleteT() 
    {
        rol_usuarioService = new Rol_UsuarioService();
        t = new Rol_Usuario();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setRol(new Roles(getParameter("rol")));
        if( t.getUsuario().getUsuario() != null && t.getUsuario().getUsuario().length() > 0 &&
            t.getRol().getRolUsuario() != null && t.getRol().getRolUsuario().length() > 0)
        {
            return rol_usuarioService.deleteRol_Usuario(t);
        }
        return false;
    }
    
    @Override
    public Rol_Usuario getTByKey() 
    {
        String usuario = null;
        String rol = null;
        
        usuario = getParameter("user");
        rol = getParameter("rol");
        
        if( usuario == null || usuario.length() <= 0 || rol == null || rol.length( ) <= 0)
        {
            return null;
        }
   
        rol_usuarioService = new Rol_UsuarioService();
        return rol_usuarioService.getRol_UsuarioByRol_Usuario(rol, usuario);
    }
}
