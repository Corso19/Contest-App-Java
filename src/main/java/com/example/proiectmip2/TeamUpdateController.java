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

public class TeamUpdateController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private TextField teamName_input;
    @FXML private TextField teamId_input;

    @FXML
    private void initialize (){
        personsEntity.read();
    }

    @FXML
    private void onUpdateClick (ActionEvent event) throws IOException {
        if(teamName_input.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Process fail");
            alert.setContentText("Please insert a new team name!");
            alert.show();
        } else {
            connection.AdminUpdateTeam(teamName_input.getText(), Integer.parseInt(teamId_input.getText()));


            Alert warningAlert = new Alert(Alert.AlertType.CONFIRMATION);
            warningAlert.setTitle("Success!");
            warningAlert.setContentText("Very nice!");
            warningAlert.show();

            Parent root = FXMLLoader.load(getClass().getResource("UserManagementAdmin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Stage Management");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void onReturnToUsrMngClick (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserManagementAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

}
