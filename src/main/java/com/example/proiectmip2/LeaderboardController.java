package com.example.proiectmip2;

import Entity.FinalResultsEntity;
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
import java.util.ArrayList;
import java.util.List;


public class LeaderboardController {

    private Stage stage;
    private Scene scene;
    private DBConnection connection = new DBConnection();
    private PersonsEntity personsEntity = new PersonsEntity();

    @FXML private TextField  stageId_input;

    @FXML
    private void onViewClick(ActionEvent event) throws IOException {
        if(stageId_input.getText().isEmpty())
        {
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Warning!");
            warningAlert.setContentText("Make sure that you enter some data!");
            warningAlert.show();
        }
        else {

            List<FinalResultsEntity> finalResultsEntityList = new ArrayList<>();

            finalResultsEntityList = connection.ViewLeaderboard(Integer.parseInt(stageId_input.getText()));
            for (FinalResultsEntity finalResult : finalResultsEntityList) {
                System.out.println(finalResult.getNume() +" " + finalResult.getNume_echipa() + " " +finalResult.getPunctaj());
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
