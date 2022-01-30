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

public class AccountEditController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML private TextField  username_input;
    @FXML private TextField name_input;
    @FXML private TextField teamId_input;

    @FXML
    public void initialize() {
        personsEntity.read();
    }


    @FXML
    private void onUpdateAccountInformationClick(ActionEvent event) throws IOException{
        if(username_input.getText().isEmpty() && name_input.getText().isEmpty() && teamId_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Make sure that you enter some data!");
            warningAlert.show();
        }
        else {
            int idpersoana = personsEntity.getId(), idechipa;
            String username ;
            String nume ;

            if(username_input.getText().isEmpty())
                username = personsEntity.getUsername();
            else
                username = username_input.getText();

            if(name_input.getText().isEmpty())
                nume = personsEntity.getNume();
            else
                nume = name_input.getText();

            if(teamId_input.getText().isEmpty())
                idechipa = personsEntity.getIdEchipa();
            else
                idechipa = Integer.parseInt(teamId_input.getText());

            connection.UpdateUserAccount(idpersoana,idechipa,username,nume);

            if(personsEntity.isIs_admin() == true)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainMenuAdmin.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                stage.show();
            }
            else if(personsEntity.isIs_admin() == false)
            {
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Main Menu");
                stage.setScene(scene);
                stage.show();
            }

        }
    }

    @FXML
    private void onReturnToMenuClick(ActionEvent event) throws IOException{

        if(personsEntity.isIs_admin() == true)
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenuAdmin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        }
        else if (personsEntity.isIs_admin() == false)
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        }

    }

}
