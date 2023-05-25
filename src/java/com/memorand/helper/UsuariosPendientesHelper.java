package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesP;
import com.memorand.dao.Usuarios;
import com.memorand.dao.UsuariosPendientes;
import com.memorand.dao.service.UsuariosPendientesService;
import java.io.Serializable;
import java.util.List;

public class UsuariosPendientesHelper extends Helpers<UsuariosPendientes> implements Serializable
{
    private UsuariosPendientesService usuariosPendientesService;

    public UsuariosPendientesHelper() {}

    @Override
    public boolean addT() {
        usuariosPendientesService = new UsuariosPendientesService();
        t = new UsuariosPendientes();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdPendP(new PendientesP(Integer.parseInt(getParameter("idPendP"))));
        
        return usuariosPendientesService.addUsuariosPendientes(t);
    }

    @Override
    public List<UsuariosPendientes> getListT() {
       usuariosPendientesService = new UsuariosPendientesService();
       return usuariosPendientesService.getUsuariosPendientesList();
    }

    @Override
    public boolean updateT() {
        return false;
    }

    @Override
    public boolean deleteT() {
        usuariosPendientesService = new UsuariosPendientesService();
        t = new UsuariosPendientes();
        int idPendP = t.getIdPendP().getIdPendP();
        String idPendPString = String.valueOf(idPendP);

        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdPendP(new PendientesP(Integer.parseInt(getParameter("idPendP"))));
        if( t.getUsuario().getUsuario() != null && t.getUsuario().getUsuario().length() > 0 &&
            idPendPString != null && idPendPString.length() > 0)
        {
            return usuariosPendientesService.deleteUsuariosPendientes(t);
        }
        return false;
    }

    @Override
    public UsuariosPendientes getTByKey() {
        String usuario = null;
        String idPendP = null;
        
        usuario = getParameter("user");
        idPendP = getParameter("idPendP");
        
        if( usuario == null || usuario.length() <= 0 || idPendP == null || idPendP.length( ) <= 0)
        {
            return null;
        }
        
        int idPendPI = Integer.parseInt(idPendP);
        usuariosPendientesService = new UsuariosPendientesService();
        return usuariosPendientesService.getUsuariosPendientesByUsuarioIdPendP(idPendPI, usuario);
    }
}