package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasC;
import com.memorand.dao.service.EtiquetasCService;
import java.io.Serializable;
import java.util.List;

public class EtiquetasCHelper extends Helpers<EtiquetasC> implements Serializable
{
    private EtiquetasCService etiquetasCService;

    public EtiquetasCHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNull( t.getIdEtiquetaC() ) &&
               isNotNullAndNotEmpty( t.getNomEtiquetaC() );
    }
    
    @Override
    public boolean addT() {
        etiquetasCService = new EtiquetasCService();
        t = new EtiquetasC();

        t.setIdEtiquetaC(Integer.parseInt((getParameter("idEtiquetaC"))));
        t.setNomEtiquetaC(getParameter("nomEtiquetaC"));
        
        if( isValidaCamposOk( ) )
        {
            return etiquetasCService.addEtiquetasC(t );
        }
        return false;
    }

    @Override
    public List<EtiquetasC> getListT() {
       etiquetasCService = new EtiquetasCService();
       return etiquetasCService.getEtiquetasCList();
    }

    @Override
    public boolean updateT() {
        etiquetasCService = new EtiquetasCService();
        t = new EtiquetasC();
        t.setIdEtiquetaC(Integer.parseInt(getParameter("idEtiquetaC")));
        t.setNomEtiquetaC(getParameter("nomEtiquetaC"));
        if( isValidaCamposOk( ) )
        {
            return etiquetasCService.updateEtiquetasC(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        etiquetasCService = new EtiquetasCService();
        t = new EtiquetasC();
        
        t.setIdEtiquetaC(Integer.parseInt(getParameter("idEtiquetaC")));
        int idEtiquetaC = t.getIdEtiquetaC();
        String idEtiquetaCString = String.valueOf(idEtiquetaC);
        
        if( idEtiquetaCString != null || idEtiquetaCString.length() > 0 )
        {
            return etiquetasCService.deleteEtiquetasC(t);
        }
        return false;
    }

    @Override
    public EtiquetasC getTByKey() {
        String idEtiquetaC = null;
        idEtiquetaC = getParameter("idEtiquetaC");
        
        if( idEtiquetaC == null || idEtiquetaC.length() <= 0 )
        {
            return null;
        }
        
        int idEtiquetaCI = Integer.parseInt(idEtiquetaC);
        etiquetasCService = new EtiquetasCService();
        return etiquetasCService.getEtiquetasCByEtiquetasC(idEtiquetaCI);
    }
}
