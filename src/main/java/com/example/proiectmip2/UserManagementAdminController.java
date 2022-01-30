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

public class UserManagementAdminController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private void initialize (){
        personsEntity.read();
    }

    @FXML
    private void onDeleteTeamClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeamDeletion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onUpdateTeamClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TeamUpdate.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onValidateTeamClick(ActionEvent event) throws IOException {

    }
}
