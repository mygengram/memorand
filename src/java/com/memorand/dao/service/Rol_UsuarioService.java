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
import com.memorand.dao.Rol_Usuario;
import com.memorand.dao.Roles;
import com.memorand.dao.Usuarios;

public class Rol_UsuarioService extends Conexion<Rol_Usuario>
{
    public Rol_UsuarioService() {}
    
    public List<Rol_Usuario> getRol_UsuarioList() 
    {
        List<Rol_Usuario> rolUsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Rol_Usuario rol_Usuario = null;

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
            resultSet = statement.executeQuery("SELECT * FROM ROL_USUARIO");
            if (resultSet == null) 
            {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            while (resultSet.next()) 
            {
                rol_Usuario = new Rol_Usuario();
                rol_Usuario.setUsuario( new Usuarios( resultSet.getString(1) ) );
                rol_Usuario.setRol( new Roles( resultSet.getString(2) ) );
                rolUsuarioList.add(rol_Usuario);
            }
            resultSet.close();
            closeConnection(connection);
            return rolUsuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addRol_Usuario (Rol_Usuario rol_Usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ROL_USUARIOS (USUARIO,ROLUSUARIO) VALUES (?,?)";
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
            preparedStatement.setString(1, rol_Usuario.getUsuario().getUsuario());
            preparedStatement.setString(2, rol_Usuario.getRol().getRolUsuario());
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
    
    public boolean updateRol_Usuario ( Rol_Usuario rol_Usuario )
    {
        return false;
    }
    
    public boolean deleteRol_Usuario ( Rol_Usuario rol_Usuario )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ROL_USUARIO WHERE USUARIO = ? AND ROLUSUARIO = ?";
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
            preparedStatement.setString(1, rol_Usuario.getUsuario().getUsuario());
            preparedStatement.setString(2, rol_Usuario.getRol().getRolUsuario());
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
    
    public Rol_Usuario getRol_UsuarioByRol_Usuario (String rolUsuario, String usuario) 
    {
        Rol_Usuario aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM ROL_USUARIO WHERE USUARIO = ? AND ROLUSUARIO = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, rolUsuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new Rol_Usuario();
            while (resultSet.next()) 
            {
                aux.setUsuario( new Usuarios( resultSet.getString(1)));
                aux.setRol( new Roles( resultSet.getString(2)));
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
    
    public Rol_Usuario getRolUsuarioByUsuarioPassword (String usuario , String contrasena) 
    {
        Rol_Usuario aux = null;
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
            stringBuilder.append("SELECT ROL_USUARIO.ROLUSUARIO,ROL_USUARIO.USUARIO FROM ROL_USUARIO INNER JOIN USUARIOS ON ROL_USUARIO.USUARIO = USUARIOS.USUARIO");
            stringBuilder.append( " WHERE USUARIOS.USUARIO = ? AND USUARIOS.CONTRASENA = ?");
            System.out.println(stringBuilder.toString() );
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new Rol_Usuario();
            while (resultSet.next()) 
            {
                aux.setUsuario(new Usuarios( resultSet.getString(1)));
                aux.setRol(new Roles( resultSet.getString(2)));
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
