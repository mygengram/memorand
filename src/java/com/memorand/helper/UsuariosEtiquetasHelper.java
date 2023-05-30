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
        t.setIdEtiquetaP(new EtiquetasP(getParameter("idEtiquetaP")));
        
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
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdEtiquetaP(new EtiquetasP(getParameter("idEtiquetaP")));
        if(t.getUsuario() != null && t.getUsuario().length() > 0 &&
           t.getIdEtiquetaP() != null && t.getIdEtiquetaP().length() > 0) {
            return usuariosEtiquetasService.deleteUsuariosEtiquetas(t);
        }
        return false;
    }

    @Override
    public UsuariosEtiquetas getTByKey() {
        String usuario;
        String idEtiquetaP;
        
        usuario = getParameter("user");
        idEtiquetaP = getParameter("idEtiquetaP");
        
        if( usuario == null || usuario.length() <= 0 || idEtiquetaP == null || idEtiquetaP.length( ) <= 0) {
            return null;
        }
        
        usuariosEtiquetasService = new UsuariosEtiquetasService();
        return usuariosEtiquetasService.getUsuariosEtiquetas(usuario,idEtiquetaP);
    }
}
