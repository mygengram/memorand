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
import com.memorand.dao.Usuarios;

public class UsuariosService extends Conexion<Usuarios>
{
    public UsuariosService() {}
    
    public List<Usuarios> getUsuariosList() 
    {
        List<Usuarios> usuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuario = null;

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
            resultSet = statement.executeQuery("SELECT * FROM USUARIOS");
            if (resultSet == null) 
            {
                return null;
            }
            usuariosList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuario = new Usuarios();
                usuario.setUsuario(resultSet.getString(1));
                usuario.setContrasena(resultSet.getString(2));
                usuario.setNomUsuario(resultSet.getString(3));
                usuario.setApellidoPat(resultSet.getString(4));
                usuario.setApellidoMat(resultSet.getString(5));
                usuario.setFechaNac(resultSet.getDate(6));
                usuariosList.add(usuario);
            }
            resultSet.close();
            closeConnection(connection);
            return usuariosList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuario( Usuarios usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USUARIOS (USUARIO,CONTRASENA,NOMUSUARIO,APELLIDOPAT,APELLIDOMAT,FECHANAC) VALUES (?,?,?,?,?,?)";
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
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getContrasena());
            preparedStatement.setString(3, usuario.getNomUsuario());
            preparedStatement.setString(4, usuario.getApellidoPat());
            preparedStatement.setString(5, usuario.getApellidoMat());
            preparedStatement.setDate(6, dateUtil2DateSql(usuario.getFechaNac()));
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
    
    public boolean updateUsuario( Usuarios usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE USUARIOS SET CONTRASENA = ?,NOMUSUARIO = ?,APELLIDOPAT = ?,APELLIDOMAT = ?,FECHANAC = ? WHERE USUARIO = ?";
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
            preparedStatement.setString(1, usuario.getContrasena());
            preparedStatement.setString(2, usuario.getNomUsuario());
            preparedStatement.setString(3, usuario.getApellidoPat());
            preparedStatement.setString(4, usuario.getApellidoMat());
            preparedStatement.setDate(5, dateUtil2DateSql(usuario.getFechaNac()));
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
    
    public boolean deleteUsuario( Usuarios usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USUARIO WHERE USUARIO = ?";
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
            preparedStatement.setString(1, usuario.getUsuario());
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
    
    public Usuarios getUsuarioByUsuario(String usuario) 
    {
        Usuarios aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario );
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new Usuarios ( );
            while (resultSet.next()) 
            {
                aux = new Usuarios();
                aux.setUsuario(resultSet.getString(1));
                aux.setContrasena(resultSet.getString(2));
                aux.setNomUsuario(resultSet.getString(3));
                aux.setApellidoPat(resultSet.getString(4));
                aux.setApellidoMat(resultSet.getString(5));
                aux.setFechaNac(resultSet.getDate(6));
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
