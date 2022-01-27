package com.example.proiectmip2;


import Entity.PersonsEntity;

import java.sql.*;

public class DBConnection {

    private Connection connection = null;


    public void start() {
        System.out.println("Try...");
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proiectmip", "postgres", "1234");
            if(connection != null)
                System.out.println("Connected to PostgreSQL database ...");
            else
                System.out.println("Database connection failed...");

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public PersonsEntity Login(String username) {
        try{
            PersonsEntity personsEntity = new PersonsEntity();
            String sql = "SELECT persoana.idpersoana, persoana.username, persoana.nume, persoana.is_admin, echipa.nume_echipa FROM persoana JOIN echipa ON persoana.idechipa = echipa.idechipa WHERE username = '"+username+"'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                personsEntity.setId(resultSet.getInt("idpersoana"));
                personsEntity.setUsername(resultSet.getString("username"));
                personsEntity.setNume(resultSet.getString("nume"));
                personsEntity.setIs_admin(resultSet.getBoolean("is_admin"));
                personsEntity.setNume_echipa(resultSet.getString("nume_echipa"));

            }
            return personsEntity;
        }
        catch (SQLException e)
        {
            System.out.println("Persoana nu a fost gasita");
        }

        return null;
    }

    public DBConnection() {this.start();}

}
