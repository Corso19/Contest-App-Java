package com.example.proiectmip2;


import Entity.FinalResultsEntity;
import Entity.PersonsEntity;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "SELECT persoana.idpersoana, persoana.username, persoana.nume, persoana.is_admin, echipa.nume_echipa, persoana.idechipa FROM persoana JOIN echipa ON persoana.idechipa = echipa.idechipa WHERE username = '"+username+"'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                personsEntity.setId(resultSet.getInt("idpersoana"));
                personsEntity.setUsername(resultSet.getString("username"));
                personsEntity.setNume(resultSet.getString("nume"));
                personsEntity.setIs_admin(resultSet.getBoolean("is_admin"));
                personsEntity.setNume_echipa(resultSet.getString("nume_echipa"));
                personsEntity.setIdEchipa(resultSet.getInt("idechipa"));

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

    public void UpdateUserAccount(Integer idpersoana, Integer idechipa, String username, String nume) {
        try {
            String sql = "UPDATE persoana SET (username, nume, idechipa) = (?,?,?) WHERE idpersoana = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(4,idpersoana);
            preparedStatement.setInt(3, idechipa);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,nume);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println("Number of records affected: " + affectedRows);
            if(affectedRows == 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Team name not availible");
                alert.setContentText("This team name already exists in our database!");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Very nice!");
                alert.show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteUser(String username) {
        try {
            String sql = "DELETE FROM persoana WHERE username = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of records affected " +affectedrows);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Very nice!");
            alert.show();

        } catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team name not availible");
            alert.setContentText("This team name already exists in our database!");
            alert.show();
        }
    }

    public void RegisterStage(Integer idpersoana, Integer stageid, Integer punctaj, Integer idechipa) {
        try {
            String sql = "INSERT INTO final_results (idpersoana, idetapa, idechipa, punctaj) VALUES(?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,idpersoana);
            preparedStatement.setInt(2,stageid);
            preparedStatement.setInt(3,idechipa);
            preparedStatement.setInt(4,punctaj);

            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of records affected " +affectedrows);
        } catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team name not availible");
            alert.setContentText("This team name already exists in our database!");
            alert.show();
        }
    }

    public void AdminRegisterStage(Integer numaretapa)
    {
        try {
            String sql = "INSERT INTO etapa (numaretapa, is_finished) VALUES  (?,false);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setInt(1, numaretapa);

            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of records affected: " +affectedrows);


        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team name not availible");
            alert.setContentText("This team name already exists in our database!");
            alert.show();
        }

    }

    public void AdminDeleteStage(Integer numaretapa)
    {
        try{
            String sql = "DELETE FROM etapa WHERE numaretapa = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,numaretapa);

            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of rows affected: " + affectedrows);

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team name not availible");
            alert.setContentText("This team name already exists in our database!");
            alert.show();
        }
    }

    public void AdminDeleteTeam(String nume_echipa)
    {
        try {
            String sql = "DELETE FROM echipa WHERE nume_echipa = (?);";
            System.out.println("dasdada");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("2");

            preparedStatement.setString(1, nume_echipa);
            System.out.println("3");

            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of rows affected: " + affectedrows);


        } catch (SQLException e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team name not availible");
            alert.setContentText("This team name does not exist in our database!");
            alert.show();
        }
    }

    public void AdminUpdateTeam(String nume_echipa, Integer idechipa)
    {
        try{
            String sql = "UPDATE echipa SET nume_echipa = (?) WHERE idechipa = (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,nume_echipa);

            preparedStatement.setInt(2,idechipa);


            int affectedrows = preparedStatement.executeUpdate();
            System.out.println("Number of rows affected: " + affectedrows);

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Team id not availible");
            alert.setContentText("This team id does not exist in our database!");
            alert.show();
        }
    }

    public List<FinalResultsEntity> ViewLeaderboard (Integer idetapa) {
        try {


            List<FinalResultsEntity> finalResultsEntityList = new ArrayList<>();
            String sql = "SELECT persoana.nume, echipa.nume_echipa, final_results.punctaj FROM final_results INNER JOIN persoana ON persoana.idpersoana = final_results.idpersoana INNER JOIN echipa ON echipa.idechipa = final_results.idechipa WHERE idetapa = '"+idetapa+"' ORDER BY final_results.punctaj DESC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FinalResultsEntity finalResultsEntity = new FinalResultsEntity();
                finalResultsEntity.setNume(resultSet.getString("nume"));
                finalResultsEntity.setNume_echipa(resultSet.getString("nume_echipa"));
                finalResultsEntity.setPunctaj(resultSet.getInt("punctaj"));
                finalResultsEntityList.add(finalResultsEntity);
            }

            return finalResultsEntityList;

        } catch (SQLException e)
        {
            return null;
        }
    }


    public DBConnection() {this.start();}

}
