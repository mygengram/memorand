package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesP;
import com.memorand.dao.Usuarios;
import com.memorand.dao.UsuariosPendientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosPendientesService extends Conexion<UsuariosPendientes>
{
    public UsuariosPendientesService() {}
    
    public List<UsuariosPendientes> getUsuariosPendientesList() 
    {
        List<UsuariosPendientes> usuariosPendientesList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UsuariosPendientes usuariosPendientes = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("select * from usuariospendientesp");
            if (resultSet == null) {
                return null;
            }
            
            usuariosPendientesList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuariosPendientes = new UsuariosPendientes();
                usuariosPendientes.setUsuario(new Usuarios(resultSet.getString(1)));
                usuariosPendientes.setIdPendP(new PendientesP(resultSet.getString(2)));
                usuariosPendientesList.add(usuariosPendientes);
            }
            resultSet.close();
            closeConnection(connection);
            return usuariosPendientesList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<PendientesP> getPendientesListByUsuario(String usuario) 
    {
        List<PendientesP> PendientesPList = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = null;
        PendientesP pendientes = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            
            stringBuilder = new StringBuilder();
            stringBuilder.append("select * from pendientesp inner join usuariospendientesp on usuariospendientesp.idpendp = pendientesp.idpendp");
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
            
            PendientesPList = new ArrayList<>();
            while (resultSet.next()) 
            {
                pendientes = new PendientesP();
                pendientes.setIdPendP(resultSet.getString(1));
                pendientes.setNomPendP(resultSet.getString(2));
                pendientes.setSubPendP(resultSet.getString(3));
                pendientes.setDescPendP(resultSet.getString(4));
                pendientes.setFechaFinalP(resultSet.getString(5));
                pendientes.setCompletadoP(resultSet.getString(6));
                PendientesPList.add(pendientes);
            }
            
            resultSet.close();
            closeConnection(connection);
            return PendientesPList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuariosPendientes (UsuariosPendientes usuariosPendientes)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into usuariospendientesp (usuario,idpendp) values (?,?)";
        int row = 0;
        try 
        {
            connection = getConnection();
            if( connection == null ) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1,usuariosPendientes.getUsuario());
            preparedStatement.setString(2,usuariosPendientes.getIdPendP());
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
    
    public boolean deleteUsuariosPendientes (UsuariosPendientes usuariosPendientes)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from usuariospendientesp where idpendp = ?";
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
            preparedStatement.setString(1, usuariosPendientes.getUsuario());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public UsuariosPendientes getUsuariosPendientes (String usuario, String idPendP) 
    {
        UsuariosPendientes aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("select * from usuariospendientesp where usuario = ? and idpendp = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, idPendP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            
            aux = new UsuariosPendientes();
            while (resultSet.next()) 
            {
                aux.setUsuario(new Usuarios(resultSet.getString(1)));
                aux.setIdPendP(new PendientesP(resultSet.getString(2)));
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
