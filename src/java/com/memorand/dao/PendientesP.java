package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

// CLASE
public class PendientesP implements Serializable
{
    public PendientesP() {}
    
    private int idPendP;
    private String nomPendP;
    private String subPendP;
    private String descPendP;
    private Date fechaPendP;
    private InputStream imgPendPI;
    private byte[] imgPendPB;
    private String colorPendP;
    private boolean completadoP;

    public int getIdPendP() {
        return idPendP;
    }

    public void setIdPendP(int idPendP) {
        this.idPendP = idPendP;
    }

    public String getNomPendP() {
        return nomPendP;
    }

    public void setNomPendP(String nomPendP) {
        this.nomPendP = nomPendP;
    }

    public String getSubPendP() {
        return subPendP;
    }

    public void setSubPendP(String subPendP) {
        this.subPendP = subPendP;
    }

    public String getDescPendP() {
        return descPendP;
    }

    public void setDescPendP(String descPendP) {
        this.descPendP = descPendP;
    }

    public Date getFechaPendP() {
        return fechaPendP;
    }

    public void setFechaPendP(Date fechaPendP) {
        this.fechaPendP = fechaPendP;
    }

    public InputStream getImgPendPI() {
        return imgPendPI;
    }

    public void setImgPendPI(InputStream imgPendPI) {
        this.imgPendPI = imgPendPI;
    }

    public byte[] getImgPendPB() {
        return imgPendPB;
    }

    public void setImgPendPB(byte[] imgPendPB) {
        this.imgPendPB = imgPendPB;
    }

    public String getColorPendP() {
        return colorPendP;
    }

    public void setColorPendP(String colorPendP) {
        this.colorPendP = colorPendP;
    }

    public boolean isCompletadoP() {
        return completadoP;
    }

    public void setCompletadoP(boolean completadoP) {
        this.completadoP = completadoP;
    }
}
