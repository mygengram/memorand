package com.memorand.dao.service;
// Memorand by Gengram © 2023

// IMPORTACIONES
import com.memorand.dao.AgendaEtiquetas;
import com.memorand.dao.AgendasC;
import com.memorand.dao.EtiquetasC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgendaEtiquetasService extends Conexion<AgendaEtiquetas>
{

    public AgendaEtiquetasService() {}
    
    public List<AgendaEtiquetas> getAgendaEtiquetasList() 
    {
        List<AgendaEtiquetas> agendaEtiquetasList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        AgendaEtiquetas agendaEtiquetas = null;

        try {
            connection = getConnection();
            if (connection == null) {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM AGENDAETIQUETAS");
            if (resultSet == null) {
                return null;
            }
            agendaEtiquetasList = new ArrayList<>();
            while (resultSet.next()) {
                agendaEtiquetas = new AgendaEtiquetas();
                agendaEtiquetas.setIdAgenda(new AgendasC( resultSet.getInt(1) ) );
                agendaEtiquetas.setIdEtiquetaC(new EtiquetasC( resultSet.getInt(2) ) );
                agendaEtiquetasList.add(agendaEtiquetas);
            }
            resultSet.close();
            closeConnection(connection);
            return agendaEtiquetasList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addAgendaEtiquetas (AgendaEtiquetas agendaEtiquetas )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO AGENDAETIQUETAS (IDAGENDA,IDETIQUETAC) VALUES (?,?)";
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
            preparedStatement.setInt(1, agendaEtiquetas.getIdAgenda().getIdAgenda());
            preparedStatement.setInt(2, agendaEtiquetas.getIdEtiquetaC().getIdEtiquetaC());
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
    
    public boolean deleteAgendaEtiquetas ( AgendaEtiquetas agendaEtiquetas )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM AGENDAETIQUETAS WHERE IDAGENDA = ? AND IDETIQUETAC = ?";
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
            preparedStatement.setInt(1, agendaEtiquetas.getIdAgenda().getIdAgenda());
            preparedStatement.setInt(2, agendaEtiquetas.getIdEtiquetaC().getIdEtiquetaC());
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
    
    public AgendaEtiquetas getAgendaEtiquetas (int idAgenda, int idEtiquetaC) 
    {
        AgendaEtiquetas aux = null;
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
            preparedStatement = connection.prepareStatement("SELECT * FROM AGENDAETIQUETAS WHERE IDAGENDA = ? AND IDETIQUETAC = ?");
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idAgenda);
            preparedStatement.setInt(2, idEtiquetaC);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new AgendaEtiquetas();
            while (resultSet.next()) 
            {
                aux.setIdAgenda(new AgendasC( resultSet.getInt(1)));
                aux.setIdEtiquetaC(new EtiquetasC( resultSet.getInt(2)));
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
    
    public AgendaEtiquetas getAgendaEtiquetasByIdAgendaIdEtiquetaC (int idAgenda, int idEtiquetaC) 
    {
        AgendaEtiquetas aux = null;
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
            stringBuilder.append("SELECT AGENDAETIQUETAS.IDAGENDA,AGENDAETIQUETAS.IDETIQUETAC FROM AGENDAETIQUETAS INNER JOIN AGENDASC ON AGENDAETIQUETAS.IDAGENDA = AGENDASC.IDAGENDA");
            stringBuilder.append( " WHERE AGENDASC.IDAGENDA = ? AND USUARIOS.NOMAGENDA = ?");
            System.out.println(stringBuilder.toString() );
            preparedStatement = connection.prepareStatement( stringBuilder.toString());
            if (preparedStatement == null) 
            {
                return null;
            }
            preparedStatement.setInt(1, idAgenda);
            preparedStatement.setInt(2, idEtiquetaC);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) 
            {
                return null;
            }
            aux = new AgendaEtiquetas();
            while (resultSet.next()) 
            {
                aux.setIdAgenda(new AgendasC( resultSet.getInt(1)));
                aux.setIdEtiquetaC(new EtiquetasC( resultSet.getInt(2)));
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
