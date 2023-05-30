package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendasC;
import com.memorand.dao.Llevan;
import com.memorand.dao.PendientesC;
import com.memorand.dao.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LlevanService extends Conexion<Llevan>
{
    public LlevanService() {}
    
    public List<Llevan> getLlevanList() 
    {
        List<Llevan> agendaEtiquetasList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Llevan llevan = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM LLEVAN");
            if (resultSet == null) {
                return null;
            }
            agendaEtiquetasList = new ArrayList<>();
            while (resultSet.next()) {
                llevan = new Llevan();
                llevan.setIdLlevan(resultSet.getInt(1));
                llevan.setUsuario(new Usuarios(resultSet.getString(2)));
                llevan.setIdAgenda(new AgendasC(resultSet.getInt(3)));
                llevan.setRolAgenda(resultSet.getString(4));
                llevan.setFavorito(resultSet.getString(5));
                agendaEtiquetasList.add(llevan);
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
    
    public boolean addLlevan (Llevan llevan)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO LLEVAN (IDTIENEN,USUARIO,IDAGENDA,ROLAGENDA,FAVORITO) VALUES (?,?,?,?,?)";
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
            preparedStatement.setInt(1,llevan.getIdLlevan());
            preparedStatement.setString(2,llevan.getUsuario().getUsuario());
            preparedStatement.setInt(3,llevan.getIdAgenda().getIdAgenda());
            preparedStatement.setString(4,llevan.getRolAgenda());
            preparedStatement.setString(5,llevan.getFavorito());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteLlevan (Llevan llevan)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM TIENEN WHERE IDLLEVAN = ?";
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
            preparedStatement.setInt(1,llevan.getIdLlevan());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Llevan getLlevan (int idLlevan) 
    {
        Llevan aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM LLEVAN WHERE IDLLEVAN = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setInt(1,idLlevan);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new Llevan();
            while (resultSet.next()) 
            {
                aux.setIdLlevan(resultSet.getInt(1));
                aux.setUsuario(new Usuarios(resultSet.getString(2)));
                aux.setIdAgenda(new AgendasC(resultSet.getInt(3)));
                aux.setRolAgenda(resultSet.getString(4));
                aux.setFavorito(resultSet.getString(5));
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
