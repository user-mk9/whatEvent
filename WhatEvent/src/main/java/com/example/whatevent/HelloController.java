package com.example.whatevent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> eventLocationBox;

    @FXML
    private ChoiceBox<String> eventTypeBox;


    @FXML
    private TextArea homeTextArea;





    ObservableList<String> EventLocationList;
    @FXML
    public void initialize(URL location, ResourceBundle resources){
        EventLocationList = FXCollections.observableArrayList("Any Type", "Dublin", "Waterford", "Kildare", "Carlow" );


        String[] types= {"Any Type", "Concert", "Drive-thru", "Movie", "Games-Night"};
        eventTypeBox.setValue("Any Type");
        eventTypeBox.getItems().addAll(types);


        eventLocationBox.setValue("Any Type");
        eventLocationBox.setItems(EventLocationList);

        eventLocationBox.setOnAction(this::searchEvent);
        eventTypeBox.setOnAction(this::searchEvent);
    }

    @FXML
    void switchToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchToRegisterPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    @FXML
    String searchEvent(ActionEvent event) {


        String results= "";

        for(event i: HelloApplication.events){
            if(eventTypeBox.getValue().equals("Any Type")){
                results += i.getEventTitle()+ " , " + i.getEventDescription() + " , " + i.getEventType() + " , " + i.getEventLocation() + " , " + i.getEventVenue() + " , " + i.getTotalPrice() +  "\n";
            }else if (eventLocationBox.getValue().equals("Any Type")){
                results += i.getEventTitle()+ " , " + i.getEventDescription() + " , " + i.getEventType() + " , " + i.getEventLocation() + " , " + i.getEventVenue() + " , " + i.getTotalPrice() +  "\n";
            }else if (i.getEventType().equals(eventTypeBox.getValue()) && i.getEventLocation().equals(eventLocationBox.getValue())){
                results += i.getEventTitle()+ " , " + i.getEventDescription() + " , " + i.getEventType() + " , " + i.getEventLocation() + " , " + i.getEventVenue() + " , " + i.getTotalPrice() +  "\n";
            }

            homeTextArea.setText(results);
        }

        return results;

    }

    //
    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }





}