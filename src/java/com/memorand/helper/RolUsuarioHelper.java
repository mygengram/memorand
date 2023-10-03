package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.RolUsuario;
import com.memorand.dao.Roles;
import com.memorand.dao.Usuarios;
import com.memorand.dao.service.RolUsuarioService;

public class RolUsuarioHelper extends Helpers<RolUsuario> implements Serializable
{
    private RolUsuarioService rolUsuarioService;
    
    public RolUsuarioHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNullAndNotEmpty(t.getRol()) && isNotNullAndNotEmpty(t.getUsuario());
    }

    @Override
    public boolean addT() 
    {
        rolUsuarioService = new RolUsuarioService();
        t = new RolUsuario();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setRol(new Roles("usuario"));
        
        if( isValidaCamposOk()) {
            return rolUsuarioService.addRolUsuario(t);
        }
        return false;
    }

    @Override
    public List<RolUsuario> getListT() 
    {
        rolUsuarioService = new RolUsuarioService();
        return rolUsuarioService.getRolUsuarioList();
    }

    @Override
    public boolean updateT() 
    { return false; }

    @Override
    public boolean deleteT() 
    {
        rolUsuarioService = new RolUsuarioService();
        t = new RolUsuario();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setRol(new Roles(getParameter("rol")));
        if( t.getUsuario() != null && t.getUsuario().length() > 0 &&
            t.getRol() != null && t.getRol().length() > 0) {
            return rolUsuarioService.deleteRolUsuario(t);
        }
        return false;
    }
    
    @Override
    public RolUsuario getTByKey() 
    {
        String usuario = null;
        String rol = null;
        usuario = getParameter("user");
        rol = getParameter("rol");
        if( usuario == null || usuario.length() <= 0 || rol == null || rol.length( ) <= 0) {
            return null;
        }
        rolUsuarioService = new RolUsuarioService();
        return rolUsuarioService.getRolUsuarioByUsuario(usuario);
    }
}
