package org.example;

import javafx.event.ActionEvent;

import java.io.IOException;

package javafx_drawsomething;

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
    //
    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

        public void initialize() {

            Circle circle_Red, circle_Green, circle_Blue;
            double orgSceneX, orgSceneY;
            double orgTranslateX, orgTranslateY;


            //Create Circles
            circle_Red = new Circle(50.0f, Color.RED);
            circle_Red.setCursor(Cursor.HAND);
            EventHandler<MouseEvent> circleOnMousePressedEventHandler = null;
            circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
            EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = null;
            circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);

            circle_Green = new Circle(50.0f, Color.GREEN);
            circle_Green.setCursor(Cursor.MOVE);
            circle_Green.setCenterX(150);
            circle_Green.setCenterY(150);
            circle_Green.setOnMousePressed(circleOnMousePressedEventHandler);
            circle_Green.setOnMouseDragged(circleOnMouseDraggedEventHandler);

            circle_Blue = new Circle(50.0f, Color.BLUE);
            circle_Blue.setCursor(Cursor.CROSSHAIR);
            circle_Blue.setTranslateX(300);
            circle_Blue.setTranslateY(100);
            circle_Blue.setOnMousePressed(circleOnMousePressedEventHandler);
            circle_Blue.setOnMouseDragged(circleOnMouseDraggedEventHandler);

            Group root = new Group();
            root.getChildren().addAll(circle_Red, circle_Green, circle_Blue);

            Stage primaryStage;
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root, 400, 350));

            primaryStage.setTitle("java-buddy");
            primaryStage.show();


            circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle) (t.getSource())).getTranslateY();
                }
            };

            circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle) (t.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (t.getSource())).setTranslateY(newTranslateY);
                }
            };


            // Media player
            MediaPlayer mp = new MediaPlayer(new Media(MEDIA_URL));

// Time label
            Label timeLabel = new Label("Time: ");
            timeLabel.setMinWidth(Control.USE_PREF_SIZE);
            mediaBar.getChildren().add(timeLabel);

// Time slider
            timeSlider = new Slider();
            HBox.setHgrow(timeSlider, Priority.ALWAYS);
            timeSlider.setMinWidth(50);
            timeSlider.setMaxWidth(Double.MAX_VALUE);
            timeSlider.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(Observable ov) {
                    if (timeSlider.isValueChanging()) {
                        // multiply duration by percentage calculated by slider position
                        if (duration != null) {
                            mp.seek(duration.multiply(timeSlider.getValue() / 100.0));
                        }
                        updateValues();
                    }
                }
            });
        }

        protected void updateValues() {
            if (playTime != null && timeSlider != null && volumeSlider != null && duration != null) {
                Platform.runLater(new Runnable() {
                    public void run() {
                        Duration currentTime = mp.getCurrentTime();
                        playTime.setText(formatTime(currentTime, duration));
                        timeSlider.setDisable(duration.isUnknown());
                        if (!timeSlider.isDisabled() && duration.greaterThan(Duration.ZERO) && !timeSlider.isValueChanging()) {
                            timeSlider.setValue(currentTime.divide(duration).toMillis() * 100.0);
                        }
                        if (!volumeSlider.isValueChanging()) {
                            volumeSlider.setValue((int) Math.round(mp.getVolume() * 100));
                        }
                    }
                });
            }
        }
        
        mp.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                updateValues();
            }
        });
// and also invoke updateValues when the MediaPlayer is played, paused, etc.

}

}
