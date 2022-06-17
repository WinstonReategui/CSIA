package org.example;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class AnalysisScreenController {
    public AnchorPane analysisScreenPane;

    //
    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
    private File file = new File("videos/zoom_0.mp4");
    private final String MEDIA_URL = file.toURI().toString();


    public void initialize() {
// create media player
        Media media = new Media (MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        mediaControl.setLayoutX(10);
        mediaControl.setLayoutY(50);

        analysisScreenPane.getChildren().add(mediaControl);

    }

}

