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
import org.w3c.dom.Text;

import java.io.IOException;

public class RegisterTeamController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();

    @FXML
    private TextField teamName_input;

    @FXML
    private void onRegisterTeamClick(ActionEvent event) throws IOException {
        if(teamName_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("You need a name for your team!");
            warningAlert.show();
        }
        else
        {
            connection.RegisterTeam(teamName_input.getText());
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
