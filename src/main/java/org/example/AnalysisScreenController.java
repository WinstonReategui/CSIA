package org.example;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AnalysisScreenController {
//
    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
}
