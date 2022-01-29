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

        if(username_input.getText().isEmpty() && name_input.getText().isEmpty() && teamId_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Introdu o data despre contul tau!");
            warningAlert.show();
        }

    }

}
