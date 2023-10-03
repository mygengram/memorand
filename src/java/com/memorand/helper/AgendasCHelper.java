package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import java.util.List;
import java.io.Serializable;
import com.memorand.dao.service.AgendasCService;

public class AgendasCHelper extends Helpers<AgendasC> implements Serializable
{
    private AgendasCService agendasCService;
    
    public AgendasCHelper() {}
    
    public boolean isValidaCamposOk()
    {
        return isNotNullAndNotEmpty(t.getIdAgenda()) &&
               isNotNullAndNotEmpty(t.getNomAgenda()) &&
               isNotNullAndNotEmpty(t.getDescAgenda()) &&
               isNotNullAndNotEmpty(t.getCodigoAgenda());
    }

    @Override
    public boolean addT() {
        agendasCService = new AgendasCService();
        t = new AgendasC();

        t.setIdAgenda(getParameter("ida"));
        t.setNomAgenda(getParameter("nma"));
        t.setDescAgenda(getParameter("dsa"));
        t.setCodigoAgenda(getParameter("cga"));
        
        if(isValidaCamposOk()) {
            return agendasCService.addAgendasC(t);
        }
        return false;
    }

    @Override
    public List<AgendasC> getListT() {
        agendasCService = new AgendasCService();
        return agendasCService.getAgendasCList();
    }

    @Override
    public boolean updateT() {
        agendasCService = new AgendasCService();
        
        t = new AgendasC();
        t.setIdAgenda(getParameter("ida"));
        t.setNomAgenda(getParameter("nma"));
        t.setDescAgenda(getParameter("dsa"));
        t.setCodigoAgenda(getParameter("cga"));
        
        if(isValidaCamposOk()) {
            return agendasCService.updateAgendasC(t);
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        agendasCService = new AgendasCService();
        t = new AgendasC();
        t.setIdAgenda(getParameter("ida"));
        if( t.getIdAgenda()!= null || t.getIdAgenda().length() > 0 ) {
            return agendasCService.deleteAgendasC(t);
        }
        return false;
    }

    @Override
    public AgendasC getTByKey() {
        String agenda = null;
        
        agenda = getParameter("user");
        if(agenda == null || agenda.length( ) <= 0) {
            return null;
        }
        agendasCService = new AgendasCService();
        return agendasCService.getAgendasCByAgendasC(agenda);
    }
}
