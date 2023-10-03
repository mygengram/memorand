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
import com.memorand.dao.Llevan;
import com.memorand.dao.Usuarios;
import com.memorand.dao.AgendasC;
import com.memorand.dao.PendientesP;

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
            resultSet = statement.executeQuery("select * from llevan");
            if (resultSet == null) {
                return null;
            }
            
            agendaEtiquetasList = new ArrayList<>();
            
            while (resultSet.next())
            {
                llevan = new Llevan();
                llevan.setIdLlevan(resultSet.getString(1));
                llevan.setUsuario(new Usuarios(resultSet.getString(2)));
                llevan.setIdAgenda(new AgendasC(resultSet.getString(3)));
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
    
    public List<AgendasC> getAgendasListByUsuario(String usuario) 
    {
        List<AgendasC> AgendasList = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = null;
        AgendasC agendas = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            
            stringBuilder = new StringBuilder();
            stringBuilder.append("select * from agendasc inner join llevan on llevan.idagenda = agendasc.idagenda");
            stringBuilder.append(" where usuario = ?");
            
            preparedStatement = connection.prepareStatement(stringBuilder.toString());
            if (preparedStatement == null) {
                return null;
            }
            
            preparedStatement.setString(1,usuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            AgendasList = new ArrayList<>();
            while (resultSet.next()) 
            {
                agendas = new AgendasC();
                agendas.setIdAgenda(resultSet.getString(1));
                agendas.setNomAgenda(resultSet.getString(2));
                agendas.setDescAgenda(resultSet.getString(3));
                agendas.setCodigoAgenda(resultSet.getString(4));
                AgendasList.add(agendas);
            }
            
            resultSet.close();
            closeConnection(connection);
            return AgendasList;
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
        String sql = "insert into llevan (idllevan,usuario,idagenda,rolagenda,favorito) values (?,?,?,?,?)";
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
            preparedStatement.setString(1,llevan.getIdLlevan());
            preparedStatement.setString(2,llevan.getUsuario());
            preparedStatement.setString(3,llevan.getIdAgenda());
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
        String sql = "delete from tienen where idllevan = ?";
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
            preparedStatement.setString(1,llevan.getIdLlevan());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Llevan getLlevanByLlevan (String idLlevan) 
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
            preparedStatement = connection.prepareStatement("select * from llevan where idllevan = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1,idLlevan);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new Llevan();
            while (resultSet.next()) 
            {
                aux.setIdLlevan(resultSet.getString(1));
                aux.setUsuario(new Usuarios(resultSet.getString(2)));
                aux.setIdAgenda(new AgendasC(resultSet.getString(3)));
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
