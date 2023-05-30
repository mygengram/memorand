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
    
    public boolean isValidaCamposOk()
    {
        return isNotNullAndNotEmpty(t.getIdPendP()) &&
               isNotNullAndNotEmpty(t.getNomPendP()) &&
               isNotNullAndNotEmpty(t.getSubPendP()) &&
               isNotNullAndNotEmpty(t.getDescPendP()) &&
               isNotNullAndNotEmpty(t.getFechaFinalP()) &&
               isNotNullAndNotEmpty(t.getCompletadoP());
    }

    @Override
    public boolean addT() {
        pendientesPService = new PendientesPService();
        t = new PendientesP();

        t.setIdPendP(codigoAleatorio12());
        t.setNomPendP(getParameter("nomPendP"));
        t.setSubPendP(getParameter("subPendP"));
        t.setDescPendP(getParameter("descPendP"));
        t.setFechaFinalP(getParameter("fechaFinalP"));
        t.setCompletadoP("no");
        
        if(isValidaCamposOk()) {
            return pendientesPService.addPendientesP(t );
        }
        return false;
    }

    @Override
    public List<PendientesP> getListT()
    {
        pendientesPService = new PendientesPService();
        return pendientesPService.getPendientesPList();
    }

    @Override
    public boolean updateT()
    {
        pendientesPService = new PendientesPService();
        t = new PendientesP();
        
        t.setIdPendP(getParameter("idPendP"));
        t.setNomPendP(getParameter("nomPendP"));
        t.setSubPendP(getParameter("subPendP"));
        t.setDescPendP(getParameter("descPendP"));
        t.setFechaFinalP(getParameter("fechaFinalP"));
        t.setCompletadoP(getParameter("completadoP"));
        
        if(isValidaCamposOk()) {
            return pendientesPService.updatePendientesP(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        pendientesPService = new PendientesPService();
        t = new PendientesP();
        t.setIdPendP(getParameter("idPendP"));
        return pendientesPService.deletePendientesP(t);
    }

    @Override
    public PendientesP getTByKey() 
    {
        String idPendP = getParameter("idPendP");
        if(idPendP == null || idPendP.length( ) <= 0) {
            return null;
        }
        pendientesPService = new PendientesPService();
        return pendientesPService.getPendientesPByPendientesP(idPendP);
    }
}
