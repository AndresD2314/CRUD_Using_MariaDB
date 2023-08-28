package com.example.Logica;

import java.sql.*;

import com.example.Interfaces.EstudianteDAOInterface;
import com.example.Model.Estudiante;

public class EstudianteDAO implements  EstudianteDAOInterface
{
    @Override
    public boolean agregarEstudiante(Estudiante estudiante)     
    {
        try 
        {
            Connection connection = DataBase.connect();
            System.out.println("Conexión establecida con éxito");
            
            String selectQuery = "SELECT * FROM estudiantes WHERE nombre = ? AND edad = ? AND carrera = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, estudiante.getNombre());
            selectStatement.setInt(2, estudiante.getEdad());
            selectStatement.setString(3, estudiante.getCarrera());

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) 
            {
                System.out.println("El estudiante ya existe en la base de datos");
                return false;
            }

            String insertQuery = "INSERT INTO estudiantes (nombre, edad, carrera) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, estudiante.getNombre());
            insertStatement.setInt(2, estudiante.getEdad());
            insertStatement.setString(3, estudiante.getCarrera());
    
            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) 
                return true;
            else 
                return false;
    
        } catch ( SQLException e) {
            e.printStackTrace();
        } 
        
        return false;
    }

    @Override
    public boolean eliminarEstudiante(Estudiante estudiante) 
    {
        try 
        {
            Connection connection = DataBase.connect();
            System.out.println("Conexión establecida con éxito");

            String selectQuery = "SELECT * FROM estudiantes WHERE nombre = ? AND edad = ? AND carrera = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, estudiante.getNombre());
            selectStatement.setInt(2, estudiante.getEdad());
            selectStatement.setString(3, estudiante.getCarrera());
            ResultSet result = selectStatement.executeQuery();

            if (!result.next())
            {
                System.out.println("No se encontro el estudiante!");
                return false;
            }
    
            String deleteQuery = "DELETE FROM estudiantes WHERE nombre = ? AND edad = ? AND carrera = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, estudiante.getNombre());
            deleteStatement.setInt(2, estudiante.getEdad());
            deleteStatement.setString(3, estudiante.getCarrera());
    
            int rowsDeleted = deleteStatement.executeUpdate();
    
            if (rowsDeleted > 0) 
            {
                System.out.println("Estudiante eliminado correctamente");
                return true;
            } 
            else 
            {
                System.out.println("No se pudo eliminar el estudiante");
                return false;
            }
    
        } catch ( SQLException e) {
            e.printStackTrace();
        } 
        return false;
    }

    @Override
    public boolean modificarEstudiante (Estudiante estudiante, Estudiante estudiante_actualizado)
    {
        try
        {
            Connection connection = DataBase.connect();
            System.out.println("Conexion establecida con exito!");

            String selectQuery = "SELECT * FROM estudiantes WHERE nombre = ? AND edad = ? AND carrera = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, estudiante.getNombre());
            selectStatement.setInt(2, estudiante.getEdad());
            selectStatement.setString(3, estudiante.getCarrera());
            ResultSet result = selectStatement.executeQuery();

            if (!result.next())
            {
                System.out.println("No se encontro el estudiante!");
                return false;
            }

            String modifyQuery = "UPDATE estudiantes SET nombre = ?, edad = ?, carrera = ? WHERE nombre = ? AND edad = ? AND carrera = ?";
            PreparedStatement updateStatement = connection.prepareStatement(modifyQuery);
            updateStatement.setString(1, estudiante_actualizado.getNombre());
            updateStatement.setInt(2, estudiante_actualizado.getEdad());
            updateStatement.setString(3, estudiante_actualizado.getCarrera());
            updateStatement.setString(4, estudiante.getNombre());
            updateStatement.setInt(5, estudiante.getEdad());
            updateStatement.setString(6, estudiante.getCarrera()); 
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated == 0)
            {
                System.out.println("No se pudo actualizar el estudiante!");
                return false;
            }
            else
                return true;

        } catch ( SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void leerEstudiantes ()
    {
        try
        {
            Connection connection = DataBase.connect();
            System.out.println("Conexion establecida con exito!");

            String selectQuery = "SELECT * FROM estudiantes";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);

            while (result.next())
            {
                System.out.println("id = " + result.getInt(1));
                System.out.println("Nombre = " + result.getString(2));
                System.out.println("Edad = " + result.getInt(3));
                System.out.println("Carrera = " + result.getString(4));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
       
}