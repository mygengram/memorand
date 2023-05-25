package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import com.memorand.dao.PendientesC;
import com.memorand.dao.Tienen;
import com.memorand.dao.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TienenService extends Conexion<Tienen>
{

    public TienenService() {}
    
    public List<Tienen> getTienenList() 
    {
        List<Tienen> tienenList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Tienen tienen = null;

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
            resultSet = statement.executeQuery("SELECT * FROM TIENEN");
            if (resultSet == null) 
            {
                return null;
            }
            tienenList = new ArrayList<>();
            while (resultSet.next()) 
            {
                tienen = new Tienen();
                tienen.setIdTienen(resultSet.getInt(1));
                tienen.setUsuario( new Usuarios (resultSet.getString(2)));
                tienen.setIdAgenda( new AgendasC(resultSet.getInt(3)));
                tienen.setIdPendC( new PendientesC (resultSet.getInt(4)));
                tienen.setAutor(resultSet.getString(5));
                
                tienenList.add(tienen);
            }
            resultSet.close();
            closeConnection(connection);
            return tienenList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        
        return null;
        }
    }
    public boolean addTienen (Tienen tienen)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TIENEN (IDTIENEN, USUARIO, IDAGENDA, IDPENDC, AUTOR) VALUES (?,?,?,?,?)";
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
            preparedStatement.setInt(1, tienen.getIdTienen());
            preparedStatement.setString(2, tienen.getUsuario().getUsuario());
            preparedStatement.setInt(3, tienen.getIdAgenda().getIdAgenda());
            preparedStatement.setInt(4, tienen.getIdPendC().getIdPendC());
            preparedStatement.setString(5, tienen.getAutor());
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
    
    public boolean updateTienen ( Tienen tienen )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE TIENEN SET IDTIENEN = ?,USUARIO = ?,IDAGENDA = ?,IDPENDC = ?,AUTOR = ? WHERE IDTIENEN = ?";
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
            preparedStatement.setInt(1, tienen.getIdTienen());
            preparedStatement.setString(2, tienen.getUsuario().getUsuario());
            preparedStatement.setInt(3, tienen.getIdAgenda().getIdAgenda());
            preparedStatement.setInt(4, tienen.getIdPendC().getIdPendC());
            preparedStatement.setString(5,tienen.getAutor());
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
    
    public boolean deleteTienen  ( Tienen  tienen  )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TIENEN WHERE IDTIENEN = ? AND USUARIO = ? AND IDAGENDA = ? AND IDPENDC = ? AND AUTOR = ?";
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
             preparedStatement.setInt(1, tienen.getIdTienen());
            preparedStatement.setString(2, tienen.getUsuario().getUsuario());
            preparedStatement.setInt(3, tienen.getIdAgenda().getIdAgenda());
            preparedStatement.setInt(4, tienen.getIdPendC().getIdPendC());
            preparedStatement.setString(5,tienen.getAutor());
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
    
    public Tienen getTienen (int idTienen, Usuarios usuario, AgendasC idAgenda, PendientesC idPendientesC, String autor ) 
    {
        Tienen aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM TIENEN WHERE IDTIENEN = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idTienen );
            preparedStatement.setString(1, usuario );
            preparedStatement.setInt(1, idTienen );
            preparedStatement.setInt(1, idTienen );
            preparedStatement.setInt(1, idTienen );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new Tienen();
            while (resultSet.next()) 
            {
                aux = new Tienen();
                aux.setIdTienen(resultSet.getInt(1));
                aux.setUsuario(resultSet.getString(2));
                aux.setIdAgenda(resultSet.getString(3));
                aux.setIdPendC(resultSet.getString(4));
                aux.setAutor(resultSet.getString(5));
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
