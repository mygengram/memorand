package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.PendientesP;
import com.memorand.dao.Roles;
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
            resultSet = statement.executeQuery("SELECT * FROM USUARIOSPENDIENTES");
            if (resultSet == null) 
            {
                return null;
            }
            usuariosPendientesList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuariosPendientes = new UsuariosPendientes();
                usuariosPendientes.setUsuario( new Usuarios( resultSet.getString(1) ) );
                usuariosPendientes.setIdPendP(new PendientesP( resultSet.getInt(2) ) );
                usuariosPendientesList.add(usuariosPendientes);
            }
            resultSet.close();
            closeConnection(connection);
            return usuariosPendientesList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuariosPendientes (UsuariosPendientes usuariosPendientes )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USUARIOSPENDIENTES (USUARIO,IDPENDP) VALUES (?,?)";
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
            preparedStatement.setString(1, usuariosPendientes.getUsuario().getUsuario());
            preparedStatement.setInt(2, usuariosPendientes.getIdPendP().getIdPendP());
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
    
    public boolean updateUsuariosPendientes ( UsuariosPendientes usuariosPendientes )
    {
        return false;
    }
    
    public boolean deleteUsuariosPendientes ( UsuariosPendientes usuariosPendientes )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USUARIOSPENDIENTES WHERE USUARIO = ? AND IDPENDP = ?";
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
            preparedStatement.setString(1, usuariosPendientes.getUsuario().getUsuario());
            preparedStatement.setInt(2, usuariosPendientes.getIdPendP().getIdPendP());
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
    
    public UsuariosPendientes getUsuariosPendientes (String usuario, int idPendP) 
    {
        UsuariosPendientes aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM USUARIOSPENDIENTES WHERE USUARIO = ? AND IDPENDP = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setInt(2, idPendP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new UsuariosPendientes();
            while (resultSet.next()) 
            {
                aux.setUsuario( new Usuarios( resultSet.getString(1)));
                aux.setIdPendP(new PendientesP( resultSet.getInt(2)));
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
    
    public UsuariosPendientes getUsuariosPendientesByUsuarioIdPendP (int idPendP, String usuario) 
    {
        UsuariosPendientes aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = null;
        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT USUARIOSPENDIENTES.USUARIO,USUARIOSPENDIENTES.IDPENDP FROM USUARIOSPENDIENTES INNER JOIN USUARIOS ON USUARIOSPENDIENTES.USUARIO = USUARIOS.USUARIO");
            stringBuilder.append( " WHERE USUARIOS.USUARIO = ? AND USUARIOS.CONTRASENA = ?");
            System.out.println(stringBuilder.toString() );
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setInt(2, idPendP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new UsuariosPendientes();
            while (resultSet.next()) 
            {
                aux.setUsuario(new Usuarios( resultSet.getString(1)));
                aux.setIdPendP(new PendientesP( resultSet.getInt(2)));
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
