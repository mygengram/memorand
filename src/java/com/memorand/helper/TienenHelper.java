package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import com.memorand.dao.PendientesC;
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.Usuarios;
import com.memorand.dao.Tienen;
import com.memorand.dao.service.TienenService;

public class TienenHelper extends Helpers<Tienen> implements Serializable
{
    private TienenService tienenService;
    
    public TienenHelper() {}
    
    public boolean isValidaCamposOk()
    {
        return isNotNullAndNotEmpty(t.getIdTienen()) &&
               isNotNullAndNotEmpty(t.getUsuario()) &&
               isNotNullAndNotEmpty(t.getIdAgenda()) &&
               isNotNullAndNotEmpty(t.getIdPendC()) &&
               isNotNullAndNotEmpty(t.getAutor());
    }

    @Override
    public boolean addT() {
        tienenService = new TienenService();
        t = new Tienen();
        t.setIdTienen(getParameter("idtn"));
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdAgenda(new AgendasC(getParameter("ida")));
        t.setIdPendC(new PendientesC(getParameter("idpendc")));
        t.setAutor(getParameter("autor"));
        
        if( isValidaCamposOk()) {
            return tienenService.addTienen(t);
        }
        return false;
    }

    @Override
    public List<Tienen> getListT() {
        tienenService = new TienenService();
        return tienenService.getTienenList();
    }

    @Override
    public boolean updateT()
    { return false; }

    @Override
    public boolean deleteT() {
        tienenService = new TienenService();
        t = new Tienen();
        t.setIdTienen(getParameter("idtn"));
        t.setUsuario(new Usuarios(getParameter("user")));
        t.setIdAgenda(new AgendasC(getParameter("ida")));
        t.setIdPendC(new PendientesC(getParameter("idpendc")));
        t.setAutor(getParameter("autor"));
        if(isValidaCamposOk()) {
            return tienenService.deleteTienen(t);
        }
        return false;
    }

    @Override
    public Tienen getTByKey() {
        String idllevan = null;
        idllevan = getParameter("idtn");
        if(idllevan == null || idllevan.length() <= 0) {
            return null;
        }
        tienenService = new TienenService();
        return tienenService.getTienenByTienen(idllevan);
    }
}
