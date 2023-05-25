package com.memorand.helper;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasP;
import com.memorand.dao.service.EtiquetasPService;
import java.io.Serializable;
import java.util.List;

public class EtiquetasPHelper extends Helpers<EtiquetasP> implements Serializable
{
    private EtiquetasPService etiquetasPService;

    public EtiquetasPHelper() {}
    
    public boolean isValidaCamposOk( )
    {
        return isNotNull( t.getIdEtiquetaP() ) &&
               isNotNullAndNotEmpty( t.getNomEtiquetaP() );
    }

    @Override
    public boolean addT() {
        etiquetasPService = new EtiquetasPService();
        t = new EtiquetasP();

        t.setIdEtiquetaP(Integer.parseInt((getParameter("idEtiquetaP"))));
        t.setNomEtiquetaP(getParameter("nomEtiquetaP"));
        
        if( isValidaCamposOk( ) )
        {
            return etiquetasPService.addEtiquetasP(t );
        }
        return false;
    }

    @Override
    public List<EtiquetasP> getListT() {
       etiquetasPService = new EtiquetasPService();
       return etiquetasPService.getEtiquetasPList();
    }

    @Override
    public boolean updateT() {
        etiquetasPService = new EtiquetasPService();
        t = new EtiquetasP();
        t.setIdEtiquetaP(Integer.parseInt(getParameter("idEtiquetaP")));
        t.setNomEtiquetaP(getParameter("nomEtiquetaP"));
        if( isValidaCamposOk( ) )
        {
            return etiquetasPService.updateEtiquetasP(t );
        }
        return false;
    }

    @Override
    public boolean deleteT() {
        etiquetasPService = new EtiquetasPService();
        t = new EtiquetasP();
        
        t.setIdEtiquetaP(Integer.parseInt(getParameter("idEtiquetaP")));
        int idEtiquetaP = t.getIdEtiquetaP();
        String idEtiquetaPString = String.valueOf(idEtiquetaP);
        
        if( idEtiquetaPString != null || idEtiquetaPString.length() > 0 )
        {
            return etiquetasPService.deleteEtiquetasP(t);
        }
        return false;
    }

    @Override
    public EtiquetasP getTByKey() {
        String idEtiquetaP = null;
        idEtiquetaP = getParameter("idEtiquetaP");
        
        if( idEtiquetaP == null || idEtiquetaP.length() <= 0 )
        {
            return null;
        }
        
        int idEtiquetaPI = Integer.parseInt(idEtiquetaP);
        etiquetasPService = new EtiquetasPService();
        return etiquetasPService.getEtiquetasPByEtiquetasP(idEtiquetaPI);
    }
}
