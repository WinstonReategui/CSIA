package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ProfileScreenController {

    public TextField mMark;
    public TextField bDate;
    public TextField aAge;
    public TextField aAverageMark;
    public TextField cCathegory;
    public TabableView refereesTable;
    public TableColumn<referee, String> refereesName = new TableColumn<>("Name");
    public ObservableList<referee> referees = FXCollections.observableArrayList();

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    ArrayList<referee> referees = new ArrayList();
    public void initialize(){

        referees.add(new referee());

        refereesName.SetCellValueFactory(new PropertyValueFactory<>("name"));
        contactsTable.getColumns.add(refereesName);
        contactsTable.setItems(contacts);

    }

    public void saveBtn(ActionEvent actionEvent){
        venues.add(new Venue(m.));
    }
}
