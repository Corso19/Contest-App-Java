package com.example.proiectmip2;


import Entity.PersonsEntity;
import javafx.scene.control.Alert;

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
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Nu exista un cont cu acest username!");
            warningAlert.show();
        }

        return null;
    }

    public void Register(String username, String nume, Integer idechipa) {
        if(connection != null)
        {
            try{
                System.out.println(username);
                String sql = "INSERT INTO persoana (username, nume ,idechipa, is_admin) VALUES(?,?,?,?);";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1,username);
                statement.setString(2, nume);
                statement.setInt(3, idechipa);
                statement.setBoolean(4, false);
                int rows =statement.executeUpdate();
                if(rows > 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!");
                    alert.setContentText("Your username is " + username);
                    alert.show();

                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username not availible");
                alert.setContentText("This username already exists in our database!");
                alert.show();
            }
        }
    }

    public void RegisterTeam(String teamName) {
        if (connection != null)
        {
            try {
                String sql = "INSERT INTO echipa (nume_echipa) VALUES (?);";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setString(1, teamName);
                int rows = statement.executeUpdate();

                if(rows > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success!");
                    alert.setContentText("Team created successfully!");
                    alert.show();
                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Team name not availible");
                alert.setContentText("This team name already exists in our database!");
                alert.show();
            }
        }
    }

    public DBConnection() {this.start();}

}
