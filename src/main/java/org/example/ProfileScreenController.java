package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;


public class ProfileScreenController {


    public TableView tableMatches;
    public TableColumn<Referee, String> refereesName = new TableColumn<>("Name");
    public TableColumn<Referee, Integer> refereesAge = new TableColumn<>("Age");
    public ObservableList<Referee> referees = FXCollections.observableArrayList();
    public TextField markTextField;
    public TextField averageMarkTextField;
    public TextField categoryTextField;
    public TextField ageTextField;
    public TextField dateTextField;
    public ChoiceBox nameRefChoiceBox;
    public TextArea notesFeedbackTextArea;
    public TableView tableDec;

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize(){

        referees.add(new Referee("Martin", 28));

        refereesName.setCellValueFactory(new PropertyValueFactory<Referee,String>("name"));

        refereesAge.setCellValueFactory(new PropertyValueFactory<Referee, Integer>("age"));

        tableMatches.getColumns().add(refereesName);
        tableMatches.getColumns().add(refereesAge);
        tableMatches.setItems(referees);

    }

    public void saveBtn(ActionEvent actionEvent){

    }

    public void saveMarkBtn(ActionEvent actionEvent) {
    }

}
