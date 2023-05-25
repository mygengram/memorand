package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import com.memorand.dao.service.AgendasCService;
import java.io.Serializable;
import java.util.List;

public class AgendasCHelper extends Helpers<AgendasC> implements Serializable
{
    private AgendasCService agendasCService;

    public AgendasCHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNull( t.getIdAgenda()) &&
               isNotNullAndNotEmpty( t.getNomAgenda()) &&
               isNotNullAndNotEmpty( t.getDescAgenda()) &&
               isNotNullAndNotEmpty( t.getColorAgenda()) &&
               isNotNullAndNotEmpty(t.getCodigoAgenda());
    }

    @Override
    public boolean addT() {
        agendasCService = new AgendasCService();
        t = new AgendasC();

        t.setIdAgenda(Integer.parseInt((getParameter("idAgenda"))));
        t.setNomAgenda(getParameter("nomAgendaC"));
        t.setDescAgenda(getParameter("descagenda"));
        t.setColorAgenda(getParameter("colorAgenda"));
        t.setCodigoAgenda(getParameter("codigoApgenda"));
        
        if( isValidaCamposOk( ) )
        {
            return agendasCService.addAgendasC(t );
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
        
        t.setIdAgenda(Integer.parseInt((getParameter("idAgenda"))));
        t.setNomAgenda(getParameter("nomAgendaC"));
        t.setDescAgenda(getParameter("descagenda"));
        t.setColorAgenda(getParameter("colorAgenda"));
        t.setCodigoAgenda(getParameter("codigoApgenda"));
        
        if( isValidaCamposOk( ) )
        {
            return agendasCService.updateAgendasC(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        agendasCService = new AgendasCService();
        t = new AgendasC();
        t.setIdAgenda(Integer.parseInt((getParameter("idAgenda"))));
        int idAgenda = t.getIdAgenda();
        String idAgendaString = String.valueOf(idAgenda);
        
        if( idAgendaString != null || idAgendaString.length() > 0 )
        {
            return agendasCService.deleteAgendasC(t);
        }
        return false;
    }

    @Override
    public AgendasC getTByKey() {
        
        String idAgenda = null;
        
        idAgenda = getParameter("idAgenda");
        if( idAgenda == null || idAgenda.length( ) <= 0 )
        {
            return null;
        }
        
        int idAgendaI = Integer.parseInt(idAgenda);
        agendasCService = new AgendasCService();
        return agendasCService.getAgendasCByAgendasC(idAgendaI);
    }
}
