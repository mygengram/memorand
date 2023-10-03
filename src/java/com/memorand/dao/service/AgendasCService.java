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

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("select * from agendasc");
            if (resultSet == null) {
                return null;
            }
            
            agendasCList = new ArrayList<>();
            while (resultSet.next()) 
            {
                agendasC = new AgendasC();
                agendasC.setIdAgenda(resultSet.getString(1));
                agendasC.setNomAgenda(resultSet.getString(2));
                agendasC.setDescAgenda(resultSet.getString(3));
                agendasC.setCodigoAgenda(resultSet.getString(4));
                agendasCList.add(agendasC);
            }
            resultSet.close();
            closeConnection(connection);
            return agendasCList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addAgendasC (AgendasC agendasC )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into agendasc (idagenda, nomagenda, descagenda, codigoagenda) values (?,?,?,?)";
        int row = 0;
        
        try {
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
            preparedStatement.setString(1,agendasC.getIdAgenda());
            preparedStatement.setString(2,agendasC.getNomAgenda());
            preparedStatement.setString(3,agendasC.getDescAgenda());
            preparedStatement.setString(4,agendasC.getCodigoAgenda());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean updateAgendasC (AgendasC agendasC)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update agendasc set nomagenda = ?, descagenda = ?, codigoagenda = ? where idagenda = ?";
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
            preparedStatement.setString(1,agendasC.getNomAgenda());
            preparedStatement.setString(2,agendasC.getDescAgenda());
            preparedStatement.setString(3,agendasC.getCodigoAgenda());
            preparedStatement.setString(4,agendasC.getIdAgenda());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteAgendasC (AgendasC agendasC)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from agendasc where idagenda = ?";
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
            preparedStatement.setString(1,agendasC.getIdAgenda());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public AgendasC getAgendasCByAgendasC (String idAgenda) 
    {
        AgendasC aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("select * from agendasc where idagenda = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,idAgenda);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new AgendasC();
            while (resultSet.next()) 
            {
                aux = new AgendasC();
                aux.setIdAgenda(resultSet.getString(1));
                aux.setNomAgenda(resultSet.getString(2));
                aux.setDescAgenda(resultSet.getString(3));
                aux.setCodigoAgenda(resultSet.getString(4));
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
    
    public AgendasC getAgendasCByCodigoAgenda (String codigoAgenda) 
    {
        AgendasC aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("select * from agendasc where codigoagenda = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,codigoAgenda);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new AgendasC();
            while (resultSet.next()) 
            {
                aux = new AgendasC();
                aux.setIdAgenda(resultSet.getString(1));
                aux.setNomAgenda(resultSet.getString(2));
                aux.setDescAgenda(resultSet.getString(3));
                aux.setCodigoAgenda(resultSet.getString(4));
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