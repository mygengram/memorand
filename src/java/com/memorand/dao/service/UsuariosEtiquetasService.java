package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.EtiquetasP;
import com.memorand.dao.Usuarios;
import com.memorand.dao.UsuariosEtiquetas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosEtiquetasService extends Conexion<UsuariosEtiquetas>
{

    public UsuariosEtiquetasService() {}
    
    public List<UsuariosEtiquetas> getUsuariosEtiquetasList() 
    {
        List<UsuariosEtiquetas> usuariosEtiquetasList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UsuariosEtiquetas usuariosEtiquetas = null;

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
            resultSet = statement.executeQuery("SELECT * FROM USUARIOSETIQUETAS");
            if (resultSet == null) 
            {
                return null;
            }
            usuariosEtiquetasList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuariosEtiquetas = new UsuariosEtiquetas();
                usuariosEtiquetas.setUsuario( new Usuarios( resultSet.getString(1) ) );
                usuariosEtiquetas.setIdEtiquetaP(new EtiquetasP( resultSet.getInt(2) ) );
                usuariosEtiquetasList.add(usuariosEtiquetas);
            }
            resultSet.close();
            closeConnection(connection);
            return usuariosEtiquetasList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addUsuariosEtiquetas (UsuariosEtiquetas usuariosEtiquetas )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USUARIOSETIQUETAS (USUARIO,IDETIQUETAP) VALUES (?,?)";
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
            preparedStatement.setString(1, usuariosEtiquetas.getUsuario().getUsuario());
            preparedStatement.setInt(2, usuariosEtiquetas.getIdEtiquetaP().getIdEtiquetaP());
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
    
    public boolean updateUsuariosEtiquetas ( UsuariosEtiquetas usuariosEtiquetas )
    {
        return false;
    }
    
    public boolean deleteUsuariosEtiquetas ( UsuariosEtiquetas usuariosEtiquetas )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USUARIOSETIQUETAS WHERE USUARIO = ? AND IDETIQUETAP = ?";
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
            preparedStatement.setString(1, usuariosEtiquetas.getUsuario().getUsuario());
            preparedStatement.setInt(2, usuariosEtiquetas.getIdEtiquetaP().getIdEtiquetaP());
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
    
    public UsuariosEtiquetas getUsuariosEtiquetas (String usuario, int idEtiquetaP) 
    {
        UsuariosEtiquetas aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM USUARIOSETIQUETAS WHERE USUARIO = ? AND IDETIQUETAP = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setInt(2, idEtiquetaP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new UsuariosEtiquetas();
            while (resultSet.next()) 
            {
                aux.setUsuario( new Usuarios( resultSet.getString(1)));
                aux.setIdEtiquetaP(new EtiquetasP( resultSet.getInt(2)));
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
    
    public UsuariosEtiquetas getUsuariosEtiquetasByUsuarioIdEtiquetaP (String usuario, int idEtiquetaP) 
    {
        UsuariosEtiquetas aux = null;
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
            stringBuilder.append("SELECT USUARIOSETIQUETAS.USUARIO,USUARIOSETIQUETAS.IDETIQUETAP FROM USUARIOSETIQUETAS INNER JOIN USUARIOS ON USUARIOSETIQUETAS.USUARIO = USUARIOS.USUARIO");
            stringBuilder.append( " WHERE USUARIOS.USUARIO = ? AND USUARIOS.CONTRASENA = ?");
            System.out.println(stringBuilder.toString() );
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setString(1, usuario);
            preparedStatement.setInt(2, idEtiquetaP);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new UsuariosEtiquetas();
            while (resultSet.next()) 
            {
                aux.setUsuario(new Usuarios( resultSet.getString(1)));
                aux.setIdEtiquetaP(new EtiquetasP( resultSet.getInt(2)));
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
