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
        RolUsuario rolUsuario = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("select * from rolusuarios");
            if (resultSet == null) {
                return null;
            }
            rolUsuarioList = new ArrayList<>();
            
            while (resultSet.next()) 
            {
                rolUsuario = new RolUsuario();
                rolUsuario.setUsuario(new Usuarios(resultSet.getString(1)));
                rolUsuario.setRol(new Roles(resultSet.getString(2)));
                rolUsuarioList.add(rolUsuario);
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
        String sql = "insert into rolusuarios (usuario,rolusuario) values (?,?)";
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
        String sql = "delete from rolusuarios where usuario = ?";
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
            preparedStatement = connection.prepareStatement("select * from rolusuarios where usuario = ?");
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
    
    public RolUsuario getRolUsuarioByContrasena (String usuario, String contrasena) 
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
            stringBuilder.append("select rolusuarios.usuario, rolusuarios.rolusuario from rolusuarios inner join usuarios on rolusuarios.usuario = usuarios.usuario");
            stringBuilder.append(" where usuarios.usuario = ? and usuarios.contrasena = ?");
            
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) {
                return null;
            }
            
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
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
