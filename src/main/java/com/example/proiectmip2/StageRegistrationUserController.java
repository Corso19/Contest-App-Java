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

public class StageRegistrationUserController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();


    @FXML private TextField score_input;
    @FXML private TextField stageid_input;

    @FXML
    public void initialize() {
        personsEntity.read();
    }

    @FXML
    private void onStageRegisterButtonClick(ActionEvent event) throws IOException{
        if(score_input.getText().isEmpty() || stageid_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("You did not enter any vaild data!");
            warningAlert.show();
        } else {
            connection.RegisterStage(personsEntity.getId(), Integer.parseInt(stageid_input.getText()), Integer.parseInt(score_input.getText()), personsEntity.getIdEchipa());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Very nice!");
            alert.show();

            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        }
    }

}
