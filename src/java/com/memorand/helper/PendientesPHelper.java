package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesP;
import com.memorand.dao.service.PendientesPService;
import java.util.List;
import java.io.Serializable;

public class PendientesPHelper extends Helpers<PendientesP> implements Serializable
{
    private PendientesPService pendientesPService;

    public PendientesPHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNull( t.getIdPendP()) &&
               isNotNullAndNotEmpty( t.getNomPendP()) &&
               isNotNullAndNotEmpty( t.getSubPendP()) &&
               isNotNullAndNotEmpty( t.getDescPendP()) &&
               isNotNull( t.getFechaInicioP()) &&
               isNotNull( t.getFechaFinalP()) &&
               isNotNullAndNotEmpty( t.getColorPendP()) &&
               isNotNull( t.isCompletadoP());
    }

    @Override
    public boolean addT() {
        pendientesPService = new PendientesPService();
        t = new PendientesP();

        t.setIdPendP(Integer.parseInt((getParameter("idPendP"))));
        t.setNomPendP(getParameter("nomPendP"));
        t.setSubPendP(getParameter("subPendP"));
        t.setDescPendP(getParameter("descPendP"));
        t.setFechaInicioP(string2Date( getParameter("fechaInicioP")));
        t.setFehcFinalP(string2Date(getParameter("fechaFinalP")));
        t.setColorPendP(getParameter("colorPendP"));
        t.setCompletadoP(Boolean.getBoolean("completadoP"));
        
        
        if( isValidaCamposOk( ) )
        {
            return pendientesPService.addPendientesP(t );
        }
        return false;
    }

    @Override
    public List<PendientesP> getListT() {
        pendientesPService = new PendientesPService();
        return pendientesPService.getPendientesPList();
    }

    @Override
    public boolean updateT() {
        pendientesPService = new PendientesPService();
        t = new PendientesP();
        
        t.setIdPendP(Integer.parseInt((getParameter("idPendP"))));
        t.setNomPendP(getParameter("nomPendP"));
        t.setSubPendP(getParameter("subPendP"));
        t.setDescPendP(getParameter("descPendP"));
        t.setFechaInicioP(string2Date( getParameter("fechaInicioP")));
        t.setFehcFinalP(string2Date(getParameter("fechaFinalP")));
        t.setColorPendP(getParameter("colorPendP"));
        t.setCompletadoP(Boolean.getBoolean("completadoP"));
        
        if( isValidaCamposOk( ) )
        {
            return pendientesPService.updatePendientesP(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        pendientesPService = new PendientesPService();
        t = new PendientesP();
        t.setIdPendP(Integer.parseInt((getParameter("idPendP"))));
        int idPendP = t.getIdPendP();
        String idPendPString = String.valueOf(idPendP);
        
        if( idPendPString != null || idPendPString.length() > 0 )
        {
            return pendientesPService.deletePendientesP(t);
        }
        return false;
    }

    @Override
    public PendientesP getTByKey() 
    {
        String idPendP = null;
        
        idPendP = getParameter("idPendP");
        if( idPendP == null || idPendP.length( ) <= 0 )
        {
            return null;
        }
        
        int idPendPI = Integer.parseInt(idPendP);
        pendientesPService = new PendientesPService();
        return pendientesPService.getPendientesPByPendientesP(idPendPI);
    }
    
    
}
