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


public class RegisterController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private TextField username_input;
    @FXML private TextField name_input;
    @FXML private TextField teamId_input;

    @FXML
    private void onRegisterAccountClick(ActionEvent event) throws IOException{

        if(username_input.getText().isEmpty() || name_input.getText().isEmpty() || teamId_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Introdu toate datele despre contul tau!");
            warningAlert.show();
        }
        else {
            connection.Register(username_input.getText(), name_input.getText(), Integer.parseInt(teamId_input.getText()));
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    private void onReturnToMenuClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}


