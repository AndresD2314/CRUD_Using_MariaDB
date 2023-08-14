package com.example.Logica;

import java.sql.*;

public class DataBase 
{
    static Connection connection = null;

    public static Connection connect ()
    {
        try
        {
           String DB_URL = "jdbc:mariadb://localhost:3306/estudiantes";
           String DB_USER = "root";
           String DB_PASSWORD = "";
           Class.forName("org.mariadb.jdbc.Driver");

           connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
