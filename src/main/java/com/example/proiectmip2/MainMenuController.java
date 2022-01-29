package com.example.proiectmip2;

import Entity.PersonsEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML
    private void initialize (){
        personsEntity.read();
    }

    @FXML
    private void onInscriereEtapaClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StageRegistrationUser.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Edit account");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClasamentClick(ActionEvent event) throws IOException {

    }

    @FXML
    private void onEditareContClick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AccountEdit.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Edit account");
        stage.setScene(scene);
        stage.show();
    }

    @FXML private void onLogOutClick(ActionEvent event) throws IOException {
        personsEntity.empty();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

    }

    @FXML private void onDeleteAccountClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserAccountDeletion.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }


}
