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

public class UserAccountDeletionController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    public void initialize() {
        personsEntity.read();
    }

    @FXML private TextField  username_input;

    @FXML
    private void onDeleteButtonClick(ActionEvent event) throws IOException {
        if(username_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("You did not enter your username!");
            warningAlert.show();
        } else if (username_input.getText().equals(personsEntity.getUsername()))
        {
            connection.DeleteUser(username_input.getText());
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("You did not enter your username!");
            warningAlert.show();
        }
    }
}
