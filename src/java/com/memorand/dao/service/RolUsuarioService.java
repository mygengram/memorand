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
import com.memorand.dao.RolUsuario;
import com.memorand.dao.Roles;
import com.memorand.dao.Usuarios;

public class RolUsuarioService extends Conexion<RolUsuario>
{
    public RolUsuarioService() {}
    
    public List<RolUsuario> getRolUsuarioList() 
    {
        List<RolUsuario> rolUsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        RolUsuario rol_Usuario = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM ROL_USUARIO");
            if (resultSet == null) {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            
            while (resultSet.next()) 
            {
                rol_Usuario = new RolUsuario();
                rol_Usuario.setUsuario(new Usuarios(resultSet.getString(1)));
                rol_Usuario.setRol(new Roles(resultSet.getString(2)));
                rolUsuarioList.add(rol_Usuario);
            }
            
            resultSet.close();
            closeConnection(connection);
            return rolUsuarioList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addRolUsuario (RolUsuario rolUsuario)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO ROL_USUARIO (USUARIO,ROLUSUARIO) VALUES (?,?)";
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
            preparedStatement.setString(1, rolUsuario.getUsuario());
            preparedStatement.setString(2, rolUsuario.getRol());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteRolUsuario (RolUsuario rol_Usuario)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM ROL_USUARIO WHERE USUARIO = ?";
        int row = 0;
        
        try {
            connection = getConnection();
            if(connection == null) {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null ) {
                return false;
            }
            preparedStatement.setString(1, rol_Usuario.getUsuario());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public RolUsuario getRolUsuarioByUsuario (String usuario) 
    {
        RolUsuario aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM ROL_USUARIO WHERE USUARIO = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, usuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            aux = new RolUsuario();
            while (resultSet.next()) {
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
    
    public RolUsuario getRolUsuarioByContrasena (String usuario,String contrasena) 
    {
        RolUsuario aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        StringBuilder stringBuilder = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            
            stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ROL_USUARIO.USUARIO, ROL_USUARIO.ROLUSUARIO FROM ROL_USUARIO INNER JOIN USUARIOS ON ROL_USUARIO.USUARIO = USUARIOS.USUARIO");
            stringBuilder.append(" WHERE USUARIOS.USUARIO = ? AND USUARIOS.CONTRASENA = ?");
            
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) {
                return null;
            }
            
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new RolUsuario();
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
