package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.memorand.dao.Tienen;
import com.memorand.dao.AgendasC;
import com.memorand.dao.PendientesC;
import com.memorand.dao.Usuarios;

public class TienenService extends Conexion<Tienen>
{
    public TienenService() {}
    
    public List<Tienen> getTienenList() 
    {
        List<Tienen> agendaEtiquetasList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Tienen tienen = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("select * from tienen");
            if (resultSet == null) {
                return null;
            }
            
            agendaEtiquetasList = new ArrayList<>();
            
            while (resultSet.next()) {
                tienen = new Tienen();
                tienen.setIdTienen(resultSet.getString(1));
                tienen.setUsuario(new Usuarios(resultSet.getString(2)));
                tienen.setIdAgenda(new AgendasC(resultSet.getString(3)));
                tienen.setIdPendC(new PendientesC(resultSet.getString(4)));
                tienen.setAutor(resultSet.getString(5));
                agendaEtiquetasList.add(tienen);
            }
            resultSet.close();
            closeConnection(connection);
            return agendaEtiquetasList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addTienen (Tienen tienen)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into tienen (idtienen,usuario,idagenda,idpendc,autor) values (?,?,?,?,?)";
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
            preparedStatement.setString(1,tienen.getIdTienen());
            preparedStatement.setString(2,tienen.getUsuario());
            preparedStatement.setString(3,tienen.getIdAgenda());
            preparedStatement.setString(4,tienen.getIdPendC());
            preparedStatement.setString(5,tienen.getAutor());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    public boolean deleteTienen (Tienen tienen)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from tienen where idtienen = ?";
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
            preparedStatement.setString(1,tienen.getIdTienen());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Tienen getTienenByTienen (String idTienen) 
    {
        Tienen aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM TIENEN WHERE IDTIENEN = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,idTienen);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new Tienen();
            while (resultSet.next()) 
            {
                aux.setIdTienen(resultSet.getString(1));
                aux.setUsuario(new Usuarios(resultSet.getString(2)));
                aux.setIdAgenda(new AgendasC(resultSet.getString(3)));
                aux.setIdPendC(new PendientesC(resultSet.getString(4)));
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
