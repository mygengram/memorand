package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasP;
import com.memorand.dao.Usuarios;
import com.memorand.dao.UsuariosEtiquetas;
import com.memorand.dao.service.UsuariosEtiquetasService;
import java.io.Serializable;
import java.util.List;

public class UsuariosEtiquetasHelper extends Helpers<UsuariosEtiquetas> implements Serializable
{
    private UsuariosEtiquetasService usuariosEtiquetasService;
    
    
    public UsuariosEtiquetasHelper() {}

    @Override
    public boolean addT() {
        usuariosEtiquetasService = new UsuariosEtiquetasService();
        t = new UsuariosEtiquetas();
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdEtiquetaP(new EtiquetasP(Integer.parseInt(getParameter("idEtiquetaP"))));
        
        return usuariosEtiquetasService.addUsuariosEtiquetas(t);
    }

    @Override
    public List<UsuariosEtiquetas> getListT() {
        usuariosEtiquetasService = new UsuariosEtiquetasService();
        return usuariosEtiquetasService.getUsuariosEtiquetasList();
    }

    @Override
    public boolean updateT() {
        return false;
    }

    @Override
    public boolean deleteT() {
        usuariosEtiquetasService = new UsuariosEtiquetasService();
        t = new UsuariosEtiquetas();
        int idEtiquetaP = t.getIdEtiquetaP().getIdEtiquetaP();
        String idEtiquetaPString = String.valueOf(idEtiquetaP);

        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdEtiquetaP(new EtiquetasP(Integer.parseInt(getParameter("idEtiquetaP"))));
        if( t.getUsuario().getUsuario() != null && t.getUsuario().getUsuario().length() > 0 &&
            idEtiquetaPString != null && idEtiquetaPString.length() > 0)
        {
            return usuariosEtiquetasService.deleteUsuariosEtiquetas(t);
        }
        return false;
    }

    @Override
    public UsuariosEtiquetas getTByKey() {
        String usuario = null;
        String idEtiquetaP = null;
        
        usuario = getParameter("user");
        idEtiquetaP = getParameter("idEtiquetaP");
        
        if( usuario == null || usuario.length() <= 0 || usuario == null || usuario.length( ) <= 0)
        {
            return null;
        }
        
        int idEtiquetaPI = Integer.parseInt(idEtiquetaP);
        usuariosEtiquetasService = new UsuariosEtiquetasService();
        return usuariosEtiquetasService.getUsuariosEtiquetasByUsuarioIdEtiquetaP(usuario, idEtiquetaPI);
    }
    
    
}
