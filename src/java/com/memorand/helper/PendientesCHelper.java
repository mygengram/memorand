 package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesC;
import com.memorand.dao.service.PendientesCService;
import java.util.List;
import java.io.Serializable;

public class PendientesCHelper extends Helpers<PendientesC> implements Serializable
{
    private PendientesCService pendientesCService;

    public PendientesCHelper() {}
    
    public boolean isValidaCamposOk()
    {
        return isNotNullAndNotEmpty(t.getIdPendC()) &&
               isNotNullAndNotEmpty(t.getNomPendC()) &&
               isNotNullAndNotEmpty(t.getSubPendC()) &&
               isNotNullAndNotEmpty(t.getDescPendC()) &&
               isNotNullAndNotEmpty(t.getFechaFinalC()) &&
               isNotNullAndNotEmpty(t.getCompletadoC());
    }
    
    @Override
    public boolean addT() {
        pendientesCService = new PendientesCService();
        t = new PendientesC();

        t.setIdPendC(getParameter("idpp"));
        t.setNomPendC(getParameter("nmpc"));
        t.setSubPendC(getParameter("sbpc"));
        t.setDescPendC(getParameter("dspc"));
        t.setFechaFinalC(getParameter("ffpc"));
        t.setCompletadoC(getParameter("cmpc"));
        
        if(isValidaCamposOk()) {
            return pendientesCService.addPendientesC(t );
        }
        return false;
    }

    @Override
    public List<PendientesC> getListT()
    {
        pendientesCService = new PendientesCService();
        return pendientesCService.getPendientesCList();
    }

    @Override
    public boolean updateT()
    {
        pendientesCService = new PendientesCService();
        t = new PendientesC();
        
        t.setIdPendC(getParameter("idpc"));
        t.setNomPendC(getParameter("nmpc"));
        t.setSubPendC(getParameter("sbpc"));
        t.setDescPendC(getParameter("dspc"));
        t.setFechaFinalC(getParameter("ffpc"));
        t.setCompletadoC(getParameter("cmpc"));
        
        if(isValidaCamposOk()) {
            return pendientesCService.updatePendientesC(t);
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        pendientesCService = new PendientesCService();
        t = new PendientesC();
        t.setIdPendC(getParameter("idpc"));
        return pendientesCService.deletePendientesC(t);
    }

    @Override
    public PendientesC getTByKey() 
    {
        String idPendC = getParameter("idpc");
        if(idPendC == null || idPendC.length( ) <= 0) {
            return null;
        }
        pendientesCService = new PendientesCService();
        return pendientesCService.getPendientesCByPendientesC(idPendC);
    }
}
