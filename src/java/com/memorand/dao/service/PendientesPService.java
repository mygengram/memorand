package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PendientesPService extends Conexion<PendientesP>
{
    public PendientesPService() {}
        
    public List<PendientesP> getPendientesPList() 
    {
        List<PendientesP> pendientesPList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PendientesP pendientesP = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM PENDIENTESP");
            if (resultSet == null) {
                return null;
            }
            
            pendientesPList = new ArrayList<>();
            while (resultSet.next()) 
            {
                pendientesP = new PendientesP();
                pendientesP.setIdPendP(resultSet.getString(1));
                pendientesP.setNomPendP(resultSet.getString(2));
                pendientesP.setSubPendP(resultSet.getString(3));
                pendientesP.setDescPendP(resultSet.getString(4));
                pendientesP.setFechaFinalP(resultSet.getString(5));
                pendientesP.setCompletadoP(resultSet.getString(6));
                pendientesPList.add(pendientesP);
            }
            
            resultSet.close();
            closeConnection(connection);
            return pendientesPList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<PendientesP> getPendientesPComList() 
    {
        List<PendientesP> pendientesPList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PendientesP pendientesP = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM PENDIENTESP WHERE COMPLETADOP = \"si\"");
            if (resultSet == null) {
                return null;
            }
            
            pendientesPList = new ArrayList<>();
            while (resultSet.next()) 
            {
                pendientesP = new PendientesP();
                pendientesP.setIdPendP(resultSet.getString(1));
                pendientesP.setNomPendP(resultSet.getString(2));
                pendientesP.setSubPendP(resultSet.getString(3));
                pendientesP.setDescPendP(resultSet.getString(4));
                pendientesP.setFechaFinalP(resultSet.getString(5));
                pendientesP.setCompletadoP(resultSet.getString(6));
                pendientesPList.add(pendientesP);
            }
            
            resultSet.close();
            closeConnection(connection);
            return pendientesPList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<PendientesP> getPendientesPIncomList() 
    {
        List<PendientesP> pendientesPList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PendientesP pendientesP = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM PENDIENTESP WHERE COMPLETADOP = \"no\"");
            if (resultSet == null) {
                return null;
            }
            
            pendientesPList = new ArrayList<>();
            while (resultSet.next()) 
            {
                pendientesP = new PendientesP();
                pendientesP.setIdPendP(resultSet.getString(1));
                pendientesP.setNomPendP(resultSet.getString(2));
                pendientesP.setSubPendP(resultSet.getString(3));
                pendientesP.setDescPendP(resultSet.getString(4));
                pendientesP.setFechaFinalP(resultSet.getString(5));
                pendientesP.setCompletadoP(resultSet.getString(6));
                pendientesPList.add(pendientesP);
            }
            
            resultSet.close();
            closeConnection(connection);
            return pendientesPList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addPendientesP (PendientesP pendientesP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PENDIENTESP (IDPENDP, NOMPENDP, SUBPENDP, DESCPENDP, FECHAFINALP, COMPLETADOP) VALUES (?,?,?,?,?,?)";
        int row;
        
        try {
            connection = getConnection();
            if(connection == null ) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if(preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1, pendientesP.getIdPendP());
            preparedStatement.setString(2, pendientesP.getNomPendP());
            preparedStatement.setString(3, pendientesP.getSubPendP());
            preparedStatement.setString(4, pendientesP.getDescPendP());
            preparedStatement.setString(5, pendientesP.getFechaFinalP());
            preparedStatement.setString(6, pendientesP.getCompletadoP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updatePendientesP (PendientesP pendientesP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PENDIENTESP SET NOMPENDP = ?, SUBPENDP = ?, DESCPENDP = ?, FECHAINICIOP = ?, FECHAFINALP = ?, COMPLETADOP = ? WHERE IDPENDP = ?";
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
            preparedStatement.setString(1, pendientesP.getNomPendP());
            preparedStatement.setString(2, pendientesP.getSubPendP());
            preparedStatement.setString(3, pendientesP.getDescPendP());
            preparedStatement.setString(4, pendientesP.getFechaFinalP());
            preparedStatement.setString(5, pendientesP.getCompletadoP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deletePendientesP (PendientesP pendientesP)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM PENDIENTESP WHERE IDPENDP = ?";
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
            preparedStatement.setString(1, pendientesP.getIdPendP());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public PendientesP getPendientesPByPendientesP (String idPendP) 
    {
        PendientesP aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM PENDIENTESP WHERE IDPENDP = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,idPendP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new PendientesP();
            while (resultSet.next()) 
            {
                aux = new PendientesP();
                aux.setIdPendP(resultSet.getString(1));
                aux.setNomPendP(resultSet.getString(2));
                aux.setSubPendP(resultSet.getString(3));
                aux.setDescPendP(resultSet.getString(4));
                aux.setFechaFinalP(resultSet.getString(5));
                aux.setCompletadoP(resultSet.getString(6));
            }
            resultSet.close();
            closeConnection(connection);
            return aux;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
}
