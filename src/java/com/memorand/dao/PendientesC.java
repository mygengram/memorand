package com.memorand.dao;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

// CLASE
public class PendientesC implements Serializable
{
    public PendientesC() {}
    
    private int idPendC;
    private String nomPendC;
    private String subPendC;
    private String descPendC;
    private Date fechaPendC;
    private InputStream imgPendCI;
    private byte[] imgPendCB;
    private String colorPendC;
    private boolean completadoC;

    public int getIdPendC() {
        return idPendC;
    }

    public void setIdPendC(int indPendC) {
        this.idPendC = indPendC;
    }

    public String getNomPendC() {
        return nomPendC;
    }

    public void setNomPendC(String nomPendC) {
        this.nomPendC = nomPendC;
    }

    public String getSubPendC() {
        return subPendC;
    }

    public void setSubPendC(String subPendC) {
        this.subPendC = subPendC;
    }

    public String getDescPendC() {
        return descPendC;
    }

    public void setDescPendC(String descPendC) {
        this.descPendC = descPendC;
    }

    public Date getFechaPendC() {
        return fechaPendC;
    }

    public void setFechaPendC(Date fechaPendC) {
        this.fechaPendC = fechaPendC;
    }

    public InputStream getImgPendCI() {
        return imgPendCI;
    }

    public void setImgPendCI(InputStream imgPendCI) {
        this.imgPendCI = imgPendCI;
    }

    public byte[] getImgPendCB() {
        return imgPendCB;
    }

    public void setImgPendCB(byte[] imgPendCB) {
        this.imgPendCB = imgPendCB;
    }

    public String getColorPendC() {
        return colorPendC;
    }

    public void setColorPendC(String colorPendC) {
        this.colorPendC = colorPendC;
    }

    public boolean isCompletadoC() {
        return completadoC;
    }

    public void setCompletadoC(boolean completadoC) {
        this.completadoC = completadoC;
    }
}
