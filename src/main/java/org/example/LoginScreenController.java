package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class LoginScreenController {

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
            App.setRoot("MainScreen");
        }

}