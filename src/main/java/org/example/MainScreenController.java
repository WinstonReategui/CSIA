package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainScreenController {

    @FXML public static Label viewTxt;

    public static void initialize(){

    }

    @FXML


    public void myButton(ActionEvent actionEvent) {
        viewTxt.setText("this is the text I did with code");
    }

    public void switchToLoginScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("LoginScreen");
    }

    public void switchToProfileScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("ProfileScreen");
    }

    public void switchToAnalysisScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("AnalysisScreen");
    }
}