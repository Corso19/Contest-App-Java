package com.example.proiectmip2;


import Entity.PersonsEntity;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private TextField username_input;


    @FXML
    private void onLoginButtonClick(ActionEvent event) throws IOException {
        if(username_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Introdu un nume de utilizator!");
            warningAlert.show();
        }
        else
        {
            personsEntity = connection.Login(username_input.getText());
            //System.out.println(personsEntity.getNume_echipa());
            if(personsEntity.isIs_admin() == true)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainMenuAdmin.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Main Menu Admin Page");
                stage.setScene(scene);
                stage.show();
            }
            else if(personsEntity.isIs_admin() == false)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Main Menu Page");
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    private void onRegisterButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Register new account");
        stage.setScene(scene);
        stage.show();
    }
}