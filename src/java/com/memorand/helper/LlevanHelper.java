package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.Usuarios;
import com.memorand.dao.service.LlevanService;
import com.memorand.dao.Llevan;

public class LlevanHelper extends Helpers<Llevan> implements Serializable
{
    private LlevanService llevanService;
    
    public LlevanHelper() {}
    
    public boolean isValidaCamposOk()
    {
        return isNotNullAndNotEmpty(t.getIdLlevan()) &&
               isNotNullAndNotEmpty(t.getUsuario()) &&
               isNotNullAndNotEmpty(t.getIdAgenda()) &&
               isNotNullAndNotEmpty(t.getRolAgenda()) &&
               isNotNullAndNotEmpty(t.getFavorito());
    }

    @Override
    public boolean addT() {
        llevanService = new LlevanService();
        t = new Llevan();
        t.setIdLlevan(getParameter("idll"));
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdAgenda(new AgendasC(getParameter("ida")));
        t.setRolAgenda(getParameter("rol"));
        t.setFavorito(getParameter("fav"));
        
        if( isValidaCamposOk()) {
            return llevanService.addLlevan(t);
        }
        return false;
    }

    @Override
    public List<Llevan> getListT() {
        llevanService = new LlevanService();
        return llevanService.getLlevanList();
    }

    @Override
    public boolean updateT()
    { return false; }

    @Override
    public boolean deleteT() {
        llevanService = new LlevanService();
        t = new Llevan();
        t.setIdLlevan(getParameter("idll"));
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdAgenda(new AgendasC(getParameter("ida")));
        t.setRolAgenda(getParameter("rol"));
        t.setFavorito(getParameter("fav"));
        if(isValidaCamposOk()) {
            return llevanService.deleteLlevan(t);
        }
        return false;
    }

    @Override
    public Llevan getTByKey() {
        String idllevan = null;
        idllevan = getParameter("idll");
        if(idllevan == null || idllevan.length() <= 0) {
            return null;
        }
        llevanService = new LlevanService();
        return llevanService.getLlevanByLlevan(idllevan);
    }
}
