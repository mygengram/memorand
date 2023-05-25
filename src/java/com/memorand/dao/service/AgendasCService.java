package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgendasCService extends Conexion<AgendasC>
{

    public AgendasCService() {}
    
    public List<AgendasC> getAgendasCList() 
    {
        List<AgendasC> agendasCList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        AgendasC agendasC = null;

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
            resultSet = statement.executeQuery("SELECT * FROM AGENDASC");
            if (resultSet == null) 
            {
                return null;
            }
            agendasCList = new ArrayList<>();
            while (resultSet.next()) 
            {
                agendasC = new AgendasC();
                agendasC.setIdAgenda(resultSet.getInt(1));
                agendasC.setNomAgenda(resultSet.getString(2));
                agendasC.setDescAgenda(resultSet.getString(3));
                agendasC.setColorAgenda(resultSet.getString(4));
                agendasC.setCodigoAgenda(resultSet.getString(5));
                agendasCList.add(agendasC);
            }
            resultSet.close();
            closeConnection(connection);
            return agendasCList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addAgendasC (AgendasC agendasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO AGENDASC (IDAGENDA, NOMAGENDA, DESCAGENDA, DESCPENDC, CODIGOAGENDA) VALUES (?,?,?,?,?)";
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
            preparedStatement.setInt(1, agendasC.getIdAgenda());
            preparedStatement.setString(2, agendasC.getNomAgenda());
            preparedStatement.setString(3, agendasC.getDescAgenda());
            preparedStatement.setString(4, agendasC.getColorAgenda());
            preparedStatement.setString(5, agendasC.getCodigoAgenda());
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
    
    public boolean updateAgendasC ( AgendasC agendasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE AGENDASC SET IDAGENDA = ?,NOMAGENDA = ?,DESCAGENDA = ?,COLORAGENDA = ?, CODIGOAGENDA = ? WHERE IDAGENDA = ?";
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
            preparedStatement.setInt(1, agendasC.getIdAgenda());
            preparedStatement.setString(2, agendasC.getNomAgenda());
            preparedStatement.setString(3, agendasC.getDescAgenda());
            preparedStatement.setString(4, agendasC.getColorAgenda());
            preparedStatement.setString(5, agendasC.getCodigoAgenda());
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
    
    public boolean deleteAgendasC  ( AgendasC  agendasC  )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM AGENDASC WHERE IDAGENDA = ? AND NOMAGENDA = ? AND DESCAGENDA = ? AND COLORAGENDA = ? AND CODIGOAGENDA = ?";
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
            preparedStatement.setInt(1, agendasC.getIdAgenda());
            preparedStatement.setString(2, agendasC.getNomAgenda());
            preparedStatement.setString(3, agendasC.getDescAgenda());
            preparedStatement.setString(4, agendasC.getColorAgenda());
            preparedStatement.setString(5, agendasC.getCodigoAgenda());
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
    
    public AgendasC getAgendasCByAgendasC (int idAgenda) 
    {
        AgendasC aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM AGENDASC WHERE IDAGENDA = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idAgenda );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new AgendasC ( );
            while (resultSet.next()) 
            {
                aux = new AgendasC();
                aux.setIdAgenda(resultSet.getInt(1));
                aux.setNomAgenda(resultSet.getString(2));
                aux.setDescAgenda(resultSet.getString(3));
                aux.setColorAgenda(resultSet.getString(4));
                aux.setCodigoAgenda(resultSet.getString(5));
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