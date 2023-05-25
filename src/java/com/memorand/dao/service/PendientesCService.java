package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PendientesCService extends Conexion<PendientesC>
{

    public PendientesCService() {}
        
    public List<PendientesC> getPendientesCList() 
    {
        List<PendientesC> pendientesCList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PendientesC pendientesC = null;

        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM PENDIENTESC");
            if (resultSet == null) 
            {
                return null;
            }
            pendientesCList = new ArrayList<>();
            while (resultSet.next()) 
            {
                pendientesC = new PendientesC();
                pendientesC.setIdPendC(resultSet.getInt(1));
                pendientesC.setNomPendC(resultSet.getString(2));
                pendientesC.setSubPendC(resultSet.getString(3));
                pendientesC.setDescPendC(resultSet.getString(4));
                pendientesC.setFechaInicioC(resultSet.getDate(5));
                pendientesC.setFechaFinalC(resultSet.getDate(6));
                pendientesC.setColorPendC(resultSet.getString(7));
                pendientesC.setCompletadoC(resultSet.getBoolean(8));
                pendientesCList.add(pendientesC);
            }
            resultSet.close();
            closeConnection(connection);
            return pendientesCList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addPendientesC (PendientesC pendientesC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO PENDIENTESC (IDPENDC, NOMPENDC, SUBPENDC, DESCPENDC, FECHAINICIOC, FECHAFINALC, COLORPENDC, COMPLETADOC) VALUES (?,?,?,?,?,?,?,?)";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, pendientesC.getIdPendC());
            preparedStatement.setString(2, pendientesC.getNomPendC());
            preparedStatement.setString(3, pendientesC.getSubPendC());
            preparedStatement.setString(4, pendientesC.getDescPendC());
            preparedStatement.setDate(5, dateUtil2DateSql(pendientesC.getFechaInicioC()));
            preparedStatement.setDate(6, dateUtil2DateSql(pendientesC.getFechaFinalC()));
            preparedStatement.setString(7, pendientesC.getColorPendC());
            preparedStatement.setBoolean(8, pendientesC.isCompletadoC());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updatePendientesC ( PendientesC pendientesC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PENDIENTESC SET IDPENDC = ?,NOMPENDC = ?,SUBPENDC = ?,DESCPENDC = ?,FECHAINICIOC = ?,FECHAFINALC = ?,COLORPENDC = ?,COMPLETADOC = ? WHERE IDPENDC = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, pendientesC.getIdPendC());
            preparedStatement.setString(2, pendientesC.getNomPendC());
            preparedStatement.setString(3, pendientesC.getSubPendC());
            preparedStatement.setString(4, pendientesC.getDescPendC());
            preparedStatement.setDate(5, dateUtil2DateSql(pendientesC.getFechaInicioC()));
            preparedStatement.setDate(6, dateUtil2DateSql(pendientesC.getFechaFinalC()));
            preparedStatement.setString(7, pendientesC.getColorPendC());
            preparedStatement.setBoolean(8, pendientesC.isCompletadoC());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deletePendientesC  ( PendientesC  pendientesC  )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM PENDIENTESC WHERE IDPENDC = ? AND NOMPENDC = ? AND SUBPENDP = ? AND DESCPENDC = ? AND FECHAINICIOC = ? AND FECHAFINALP = ? AND COLORPENDC = ? AND COMPLETADOC = ?";
        int row = 0;
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setInt(1, pendientesC.getIdPendC());
            preparedStatement.setString(2, pendientesC.getNomPendC());
            preparedStatement.setString(3, pendientesC.getSubPendC());
            preparedStatement.setString(4, pendientesC.getDescPendC());
            preparedStatement.setDate(5, dateUtil2DateSql(pendientesC.getFechaInicioC()));
            preparedStatement.setDate(6, dateUtil2DateSql(pendientesC.getFechaFinalC()));
            preparedStatement.setString(7, pendientesC.getColorPendC());
            preparedStatement.setBoolean(8, pendientesC.isCompletadoC());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public PendientesC getPendientesCByPendientesC (int idPendC) 
    {
        PendientesC aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM PENDIENTESC WHERE IDPENDC = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idPendC );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new PendientesC ( );
            while (resultSet.next()) 
            {
                aux = new PendientesC();
                aux.setIdPendC(resultSet.getInt(1));
                aux.setNomPendC(resultSet.getString(2));
                aux.setSubPendC(resultSet.getString(3));
                aux.setDescPendC(resultSet.getString(4));
                aux.setFechaInicioC(resultSet.getDate(5));
                aux.setFechaFinalC(resultSet.getDate(6));
                aux.setColorPendC(resultSet.getString(7));
                aux.setCompletadoC(resultSet.getBoolean(8));
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
