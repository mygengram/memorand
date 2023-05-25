package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesC;
import com.memorand.dao.service.PendientesCService;
import java.io.Serializable;
import java.util.List;

public class PendientesCHelper extends Helpers<PendientesC> implements Serializable
{
    private PendientesCService pendientesCService;

    public PendientesCHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNull( t.getIdPendC()) &&
               isNotNullAndNotEmpty( t.getNomPendC()) &&
               isNotNullAndNotEmpty( t.getSubPendC()) &&
               isNotNullAndNotEmpty( t.getDescPendC()) &&
               isNotNull( t.getFechaInicioC()) &&
               isNotNull( t.getFechaFinalC()) &&
               isNotNullAndNotEmpty( t.getColorPendC()) &&
               isNotNull( t.isCompletadoC());
    }
    
    @Override
    public boolean addT() 
    {
        pendientesCService = new PendientesCService();
        t = new PendientesC();

        t.setIdPendC(Integer.parseInt((getParameter("idPendC"))));
        t.setNomPendC(getParameter("nomPendC"));
        t.setSubPendC(getParameter("subPendC"));
        t.setDescPendC(getParameter("descPendC"));
        t.setFechaInicioC(string2Date( getParameter("fechaInicioC")));
        t.setFechaFinalC(string2Date(getParameter("fechaFinalC")));
        t.setColorPendC(getParameter("colorPendC"));
        t.setCompletadoC(Boolean.getBoolean("completadoC"));
        
        
        if( isValidaCamposOk( ) )
        {
            return pendientesCService.addPendientesC(t );
        }
        return false;
    }


    @Override
    public List<PendientesC> getListT() {
        pendientesCService = new PendientesCService();
        return pendientesCService.getPendientesCList();
    }

    @Override
    public boolean updateT() {
        pendientesCService = new PendientesCService();
        t = new PendientesC();
        
        t.setIdPendC(Integer.parseInt((getParameter("idPendC"))));
        t.setNomPendC(getParameter("nomPendC"));
        t.setSubPendC(getParameter("subPendC"));
        t.setDescPendC(getParameter("descPendC"));
        t.setFechaInicioC(string2Date( getParameter("fechaInicioC")));
        t.setFechaFinalC(string2Date(getParameter("fechaFinalC")));
        t.setColorPendC(getParameter("colorPendC"));
        t.setCompletadoC(Boolean.getBoolean("completadoC"));
        
        if( isValidaCamposOk( ) )
        {
            return pendientesCService.updatePendientesC(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        pendientesCService = new PendientesCService();
        t = new PendientesC();
        t.setIdPendC(Integer.parseInt((getParameter("idPendC"))));
        int idPendC = t.getIdPendC();
        String idPendCString = String.valueOf(idPendC);
        
        if( idPendCString != null || idPendCString.length() > 0 )
        {
            return pendientesCService.deletePendientesC(t);
        }
        return false;
    }

    @Override
    public PendientesC getTByKey() {
        String idPendC = null;
        
        idPendC = getParameter("idPendC");
        if( idPendC == null || idPendC.length( ) <= 0 )
        {
            return null;
        }
        
        int idPendCI = Integer.parseInt(idPendC);
        pendientesCService = new PendientesCService();
        return pendientesCService.getPendientesCByPendientesC(idPendCI);
    }
    
    
}
