package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.Roles;
import com.memorand.dao.service.RolesService;

public class RolHelper extends Helpers<Roles> implements Serializable
{
    private RolesService rolesService;
    
    public RolHelper() {}

    @Override
    public boolean addT() 
    {
        rolesService = new RolesService();
        t = new Roles();
        t.setRolUsuario("usuario");
        t.setDescripcion("Rol usuario");
        
        return rolesService.addRol(t);
    }

    @Override
    public List<Roles> getListT() 
    {
        rolesService = new RolesService();
        return rolesService.getRolesList();
    }

    @Override
    public boolean updateT() 
    {
        return false;
    }

    @Override
    public boolean deleteT() 
    {
        return false;
    }
    
    @Override
    public Roles getTByKey() 
    {
        String rol = null;
        
        rol = "usuario";
        if( rol == null || rol.length( ) <= 0 )
        {
            return null;
        }
        rolesService = new RolesService( );
        return rolesService.getRolByRol(rol);
    }
}
