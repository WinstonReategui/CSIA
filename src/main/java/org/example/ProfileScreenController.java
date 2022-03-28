package org.example;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ProfileScreenController {


    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
}
