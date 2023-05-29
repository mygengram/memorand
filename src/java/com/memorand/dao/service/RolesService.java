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
import com.memorand.dao.Roles;

public class RolesService extends Conexion<Roles>
{
    public RolesService() {}
    
    public List<Roles> getRolesList() 
    {
        List<Roles> rolesList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Roles rol = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM ROLES");
            if (resultSet == null) {
                return null;
            }
            rolesList = new ArrayList<>();
            
            while (resultSet.next()) 
            {
                rol = new Roles();
                rol.setRolUsuario(resultSet.getString(1));
                rolesList.add(rol);
            }
            
            resultSet.close();
            closeConnection(connection);
            return rolesList;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Roles getRolByRol (String rol) 
    {
        Roles aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            preparedStatement = connection.prepareStatement("SELECT * FROM ROLES WHERE ROLUSUARIO = ?");
            if (preparedStatement == null) {
                return null;
            }
            preparedStatement.setString(1, rol);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            aux = new Roles();
            
            while (resultSet.next()) 
            {
                aux = new Roles();
                aux.setRolUsuario(resultSet.getString(1));
            }
            
            resultSet.close();
            closeConnection(connection);
            return aux;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
