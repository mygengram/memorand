package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EtiquetasCService extends Conexion<EtiquetasC>
{

    public EtiquetasCService() {}
    
    public List<EtiquetasC> getEtiquetasCList() 
    {
        List<EtiquetasC> etiquetasCList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        EtiquetasC etiquetasC = null;

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
            resultSet = statement.executeQuery("SELECT * FROM ETIQUETASC");
            if (resultSet == null) 
            {
                return null;
            }
            etiquetasCList = new ArrayList<>();
            while (resultSet.next()) 
            {
                etiquetasC = new EtiquetasC();
                etiquetasC.setIdEtiquetaC(resultSet.getInt(1));
                etiquetasC.setNomEtiquetaC(resultSet.getString(2));
                etiquetasCList.add(etiquetasC);
            }
            resultSet.close();
            closeConnection(connection);
            return etiquetasCList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addEtiquetasC (EtiquetasC etiquetasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ETIQUETASC (IDETIQUETAC,NOMETIQUETAC) VALUES (?,?)";
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
            preparedStatement.setInt(1, etiquetasC.getIdEtiquetaC());
            preparedStatement.setString(2, etiquetasC.getNomEtiquetaC());
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
    
    public boolean updateEtiquetasC ( EtiquetasC etiquetasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE ETIQUETASC SET IDETIQUETAC = ?,NOMETIQUETAC = ? WHERE IDETIQUETAC = ?";
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
            preparedStatement.setInt(1, etiquetasC.getIdEtiquetaC());
            preparedStatement.setString(2, etiquetasC.getNomEtiquetaC());
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
    
    public boolean deleteEtiquetasC ( EtiquetasC etiquetasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ETIQUETASC WHERE IDETIQUETAC = ? AND NOMETIQUETAC = ?";
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
            preparedStatement.setInt(1, etiquetasC.getIdEtiquetaC());
            preparedStatement.setString(2, etiquetasC.getNomEtiquetaC());
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
    
    public EtiquetasC getEtiquetasCByEtiquetasC (int idEtiquetaC) 
    {
        EtiquetasC aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM ETIQUETASC WHERE IDETIQUETAC = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idEtiquetaC );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new EtiquetasC ( );
            while (resultSet.next()) 
            {
                aux = new EtiquetasC();
                aux.setIdEtiquetaC(resultSet.getInt(1));
                aux.setNomEtiquetaC(resultSet.getString(2));
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
