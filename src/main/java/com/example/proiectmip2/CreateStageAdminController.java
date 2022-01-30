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

public class CreateStageAdminController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML private TextField stageNumber_input;

    @FXML
    private void initialize (){
        personsEntity.read();
    }

    @FXML
    private void onCreateStageClick() {
        if(stageNumber_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("No stage information has been provided!");
            warningAlert.show();
        }
        else {
            connection.AdminRegisterStage(Integer.parseInt(stageNumber_input.getText()));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Very nice!");
            alert.show();
        }
    }

    @FXML
    private void onReturnToStageMngClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StageManagementAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Stage Management");
        stage.setScene(scene);
        stage.show();
    }

}
