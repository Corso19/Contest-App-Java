package com.example.proiectmip2;

import Entity.PersonsEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class StageManagementAdminController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private void initialize (){
        personsEntity.read();
    }

    @FXML
    private void onCreateStageClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateStageAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onDeleteStageClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteStageAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onReturnToAdminMenuClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Main Menu Admin");
        stage.setScene(scene);
        stage.show();
    }



}
