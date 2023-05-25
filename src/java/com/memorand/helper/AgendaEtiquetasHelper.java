package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendaEtiquetas;
import com.memorand.dao.AgendasC;
import com.memorand.dao.EtiquetasC;
import com.memorand.dao.service.AgendaEtiquetasService;
import java.io.Serializable;
import java.util.List;

public class AgendaEtiquetasHelper extends Helpers<AgendaEtiquetas> implements Serializable
{
    private AgendaEtiquetasService agendaEtiquetasService;

    public AgendaEtiquetasHelper() {}

    @Override
    public boolean addT() {
        agendaEtiquetasService = new AgendaEtiquetasService();
        t = new AgendaEtiquetas();
        t.setIdAgenda(new AgendasC(Integer.parseInt((getParameter("idAgenda")) )));
        t.setIdEtiquetaC(new EtiquetasC(Integer.parseInt(getParameter("idEtiquetaC"))));
        
        return agendaEtiquetasService.addAgendaEtiquetas(t);
    }

    @Override
    public List<AgendaEtiquetas> getListT() {
        agendaEtiquetasService = new AgendaEtiquetasService();
        return agendaEtiquetasService.getAgendaEtiquetasList();
    }

    @Override
    public boolean updateT() {
        return false;
    }

    @Override
    public boolean deleteT() {
        agendaEtiquetasService = new AgendaEtiquetasService();
        t = new AgendaEtiquetas();
        
        int idAgenda = t.getIdAgenda().getIdAgenda();
        String idAgendaString = String.valueOf(idAgenda);
        
        int idEtiquetaP = t.getIdEtiquetaC().getIdEtiquetaC();
        String idEtiquetaPString = String.valueOf(idEtiquetaP);

        t.setIdAgenda(new AgendasC(Integer.parseInt(getParameter("idAgenda"))));
        t.setIdEtiquetaC(new EtiquetasC(Integer.parseInt(getParameter("idEtiquetaC"))));
        if( idAgendaString != null && idAgendaString.length() > 0 &&
            idEtiquetaPString != null && idEtiquetaPString.length() > 0)
        {
            return agendaEtiquetasService.deleteAgendaEtiquetas(t);
        }
        return false;
    }

    @Override
    public AgendaEtiquetas getTByKey() {
        String idAgenda = null;
        String idEtiquetaC = null;
        
        idAgenda = getParameter("idAgenda");
        idEtiquetaC = getParameter("idEtiquetaC");
        
        if( idAgenda == null || idAgenda.length() <= 0 || idAgenda == null || idAgenda.length( ) <= 0)
        {
            return null;
        }
        
        int idAgendaI = Integer.parseInt(idAgenda);
        int idEtiquetaCI = Integer.parseInt(idEtiquetaC);
        agendaEtiquetasService = new AgendaEtiquetasService();
        return agendaEtiquetasService.getAgendaEtiquetasByIdAgendaIdEtiquetaC(idAgendaI, idEtiquetaCI);
    }
    
    
}
