package com.gengram.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gengram.dao.Usuarios;

public class UsuariosService extends Connect<Usuarios> {

    public UsuariosService() {}
    
    // AÑADE UN USUARIO
    public boolean addUsuario(Usuarios usuario) {

        Connection connection;
        PreparedStatement preparedStatement;
        String sql = "insert into usuarios (id_usuario, correo_usuario, pass_usuario, tipo_usuario, nombre_usuario, paterno_usuario, materno_usuario) values (?,?,?,?,?,?,?)";
        int row = 0;

        try {
            connection = getConnection();

            if (connection == null) {
                return false;
            }

            preparedStatement = connection.prepareStatement(sql);

            if (preparedStatement == null) {
                return false;
            }

            preparedStatement.setString(1, usuario.getId_usuario());
            preparedStatement.setString(2, usuario.getCorreo_usuario());
            preparedStatement.setString(3, usuario.getPass_usuario());
            preparedStatement.setString(4, usuario.getTipo_usuario());
            preparedStatement.setString(5, usuario.getNombre_usuario());
            preparedStatement.setString(6, usuario.getPaterno_usuario());
            preparedStatement.setString(7, usuario.getMaterno_usuario());

            row = preparedStatement.executeUpdate();
            closeConnection(connection);

            return row == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    // SELECCIONA UN SOLO USUARIO POR NOMBRE Y PATERNO
    public Usuarios getUsuarioByNombre (String nombre, String paterno) {

        Usuarios aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = getConnection();
            if (connection == null) {
                return null;
            }

            preparedStatement = connection.prepareStatement("select * from usuarios where nombre_usuario = ? and paterno_usuario = ?");
            if (preparedStatement == null) {
                return null;
            }

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, paterno);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new Usuarios();

            while (resultSet.next()) {

                aux = new Usuarios();

                aux.setId_usuario(resultSet.getString(1));
                aux.setCorreo_usuario(resultSet.getString(2));
                aux.setPass_usuario(resultSet.getString(3));
                aux.setTipo_usuario(resultSet.getString(4));
                aux.setNombre_usuario(resultSet.getString(5));
                aux.setPaterno_usuario(resultSet.getString(6));
                aux.setMaterno_usuario(resultSet.getString(7));

            }

            resultSet.close();
            closeConnection(connection);
            return aux;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // SELECCIONA UN SOLO USUARIO POR NOMBRE Y PATERNO
    public Usuarios getUsuarioCorreo (String correo) {

        Usuarios aux = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = getConnection();
            if (connection == null) {
                return null;
            }

            preparedStatement = connection.prepareStatement("select * from usuarios where correo_usuario = ?");
            if (preparedStatement == null) {
                return null;
            }

            preparedStatement.setString(1,correo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }

            aux = new Usuarios();

            while (resultSet.next()) {

                aux = new Usuarios();

                aux.setId_usuario(resultSet.getString(1));
                aux.setCorreo_usuario(resultSet.getString(2));
                aux.setPass_usuario(resultSet.getString(3));
                aux.setTipo_usuario(resultSet.getString(4));
                aux.setNombre_usuario(resultSet.getString(5));
                aux.setPaterno_usuario(resultSet.getString(6));
                aux.setMaterno_usuario(resultSet.getString(7));

            }

            resultSet.close();
            closeConnection(connection);
            return aux;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // SELECCIONA UN SOLO USUARIO POR NOMBRE Y PATERNO
    public boolean getLogin (Usuarios usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            connection = getConnection();
            if (connection == null) {
                return false;
            }

            preparedStatement = connection.prepareStatement("select * from usuarios where correo_usuario = ? and pass_usuario = ?");
            if (preparedStatement == null) {
                return false;
            }

            preparedStatement.setString(1,usuario.getCorreo_usuario());
            preparedStatement.setString(2,usuario.getPass_usuario());
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return false;
            }

            resultSet.close();
            closeConnection(connection);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    // SELECCIONA TODOS LOS USUARIOS
    public List<Usuarios> getListUsuarios() {

        List<Usuarios> usuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuario = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return null;
            }

            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }

            resultSet = statement.executeQuery("select * from usuarios");
            if (resultSet == null) {
                return null;
            }

            usuariosList = new ArrayList<>();

            while (resultSet.next()) {
                usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setCorreo_usuario(resultSet.getString(2));
                usuario.setPass_usuario(resultSet.getString(3));
                usuario.setTipo_usuario(resultSet.getString(4));
                usuario.setNombre_usuario(resultSet.getString(5));
                usuario.setPaterno_usuario(resultSet.getString(6));
                usuario.setMaterno_usuario(resultSet.getString(7));
                usuariosList.add(usuario);
            }

            resultSet.close();
            closeConnection(connection);
            return usuariosList;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // SELECCIONA TODOS LOS PROFESORES
    public List<Usuarios> getProfes() {

        List<Usuarios> usuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuario = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return null;
            }

            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }

            resultSet = statement.executeQuery("select * from usuarios where tipo_usuario = \'profesor\'");
            if (resultSet == null) {
                return null;
            }

            usuariosList = new ArrayList<>();

            while (resultSet.next()) {
                usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setCorreo_usuario(resultSet.getString(2));
                usuario.setPass_usuario(resultSet.getString(3));
                usuario.setTipo_usuario(resultSet.getString(4));
                usuario.setNombre_usuario(resultSet.getString(5));
                usuario.setPaterno_usuario(resultSet.getString(6));
                usuario.setMaterno_usuario(resultSet.getString(7));
                usuariosList.add(usuario);
            }

            resultSet.close();
            closeConnection(connection);
            return usuariosList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // SELECCIONA TODOS LOS ALUMNOS
    public List<Usuarios> getAlumnos() {

        List<Usuarios> usuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuario = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return null;
            }

            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }

            resultSet = statement.executeQuery("select * from usuarios where tipo_usuario = \'alumno\'");
            if (resultSet == null) {
                return null;
            }

            usuariosList = new ArrayList<>();

            while (resultSet.next()) {
                usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setCorreo_usuario(resultSet.getString(2));
                usuario.setPass_usuario(resultSet.getString(3));
                usuario.setTipo_usuario(resultSet.getString(4));
                usuario.setNombre_usuario(resultSet.getString(5));
                usuario.setPaterno_usuario(resultSet.getString(6));
                usuario.setMaterno_usuario(resultSet.getString(7));
                usuariosList.add(usuario);
            }

            resultSet.close();
            closeConnection(connection);
            return usuariosList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // SELECCIONA TODOS LOS ALUMNOS
    public List<Usuarios> getAdmins() {

        List<Usuarios> usuariosList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuarios usuario = null;

        try {

            connection = getConnection();

            if (connection == null) {
                return null;
            }

            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }

            resultSet = statement.executeQuery("select * from usuarios where tipo_usuario = \'admin\'");
            if (resultSet == null) {
                return null;
            }

            usuariosList = new ArrayList<>();

            while (resultSet.next()) {
                usuario = new Usuarios();
                usuario.setId_usuario(resultSet.getString(1));
                usuario.setCorreo_usuario(resultSet.getString(2));
                usuario.setPass_usuario(resultSet.getString(3));
                usuario.setTipo_usuario(resultSet.getString(4));
                usuario.setNombre_usuario(resultSet.getString(5));
                usuario.setPaterno_usuario(resultSet.getString(6));
                usuario.setMaterno_usuario(resultSet.getString(7));
                usuariosList.add(usuario);
            }

            resultSet.close();
            closeConnection(connection);
            return usuariosList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    // ELIMINA UN USUARIO
    public boolean deleteUsuario(Usuarios usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from usuarios where id_usuario = ?";
        int row = 0;

        try {

            connection = getConnection();
            if (connection == null) {
                return false;
            }

            preparedStatement = connection.prepareStatement(sql);
            if (preparedStatement == null) {
                return false;
            }

            preparedStatement.setString(1, usuario.getId_usuario());
            row = preparedStatement.executeUpdate();
            closeConnection(connection);
            return row == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    // ACTUALIZA UN USUARIO
    public boolean updateUsuario(Usuarios usuario) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update usuarios set correo_usuario = ?, pass_usuario = ?, tipo_usuario = ?, nombre_usuario = ?, paterno_usuario = ?, materno_usuario = ? where id_usuario = ?";
        int row = 0;

        try {

            connection = getConnection();

            if (connection == null) {
                return false;
            }

            preparedStatement = connection.prepareStatement(sql);
            if (preparedStatement == null) {
                return false;
            }

            preparedStatement.setString(1, usuario.getCorreo_usuario());
            preparedStatement.setString(2, usuario.getPass_usuario());
            preparedStatement.setString(3, usuario.getTipo_usuario());
            preparedStatement.setString(4, usuario.getNombre_usuario());
            preparedStatement.setString(5, usuario.getPaterno_usuario());
            preparedStatement.setString(6, usuario.getMaterno_usuario());
            preparedStatement.setString(6, usuario.getId_usuario());

            row = preparedStatement.executeUpdate();
            closeConnection(connection);

            return row == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
