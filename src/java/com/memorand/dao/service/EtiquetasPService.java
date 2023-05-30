package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtiquetasPService extends Conexion<EtiquetasP>
{

    public EtiquetasPService() {}
    
    public List<EtiquetasP> getEtiquetasPList() 
    {
        List<EtiquetasP> etiquetasPList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        EtiquetasP etiquetasP = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM ETIQUETASP");
            if (resultSet == null) {
                return null;
            }
            etiquetasPList = new ArrayList<>();
            
            while (resultSet.next()) 
            {
                etiquetasP = new EtiquetasP();
                etiquetasP.setIdEtiquetaP(resultSet.getString(1));
                etiquetasP.setNomEtiquetaP(resultSet.getString(2));
                etiquetasPList.add(etiquetasP);
            }
            resultSet.close();
            closeConnection(connection);
            return etiquetasPList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addEtiquetasP (EtiquetasP etiquetasP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ETIQUETASP (IDETIQUETAP,NOMETIQUETAP) VALUES (?,?)";
        int row;
        int size;
        
        try {
            connection = getConnection( );
            if( connection == null ) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1,etiquetasP.getIdEtiquetaP());
            preparedStatement.setString(2,etiquetasP.getNomEtiquetaP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updateEtiquetasP (EtiquetasP etiquetasP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ETIQUETASP SET NOMETIQUETAP = ? WHERE IDETIQUETAP = ?";
        int row = 0;
        
        try {
            connection = getConnection( );
            if( connection == null ) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1,etiquetasP.getIdEtiquetaP());
            preparedStatement.setString(2,etiquetasP.getNomEtiquetaP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteEtiquetasP (EtiquetasP etiquetasP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ETIQUETASP WHERE IDETIQUETAP = ?";
        int row = 0;
        
        try {
            connection = getConnection( );
            if( connection == null ) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1,etiquetasP.getIdEtiquetaP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public EtiquetasP getEtiquetasPByEtiquetasP (String idEtiquetaP) 
    {
        EtiquetasP aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM ETIQUETASP WHERE IDETIQUETAP = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,idEtiquetaP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new EtiquetasP ();
            while (resultSet.next()) 
            {
                aux = new EtiquetasP();
                aux.setIdEtiquetaP(resultSet.getString(1));
                aux.setNomEtiquetaP(resultSet.getString(2));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
