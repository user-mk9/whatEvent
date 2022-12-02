package com.example.whatevent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class organiserPageController {

    ObservableList<String> EventTypeList = FXCollections.observableArrayList("Any Type", "Concert", "Drive-thru", "Movie", "Games-Night");
    ObservableList<String> EventLocationList = FXCollections.observableArrayList("Any Type", "Dublin", "Waterford", "Kildare", "Carlow" );

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea eventTextArea;

    @FXML
    private TextField eventDescription;

    @FXML
    private ChoiceBox<String> eventLocation;

    @FXML
    private TextField eventTitle;

    @FXML
    private ChoiceBox<String> eventType;

    @FXML
    private TextField eventVenue;

    @FXML
    private TextField totalPrice;

    @FXML
    private TextField idField;

    @FXML
    private void initialize(){
        eventType.setValue("Any Type");
        eventType.setItems(EventTypeList);

        eventLocation.setValue("Any Type");
        eventLocation.setItems(EventLocationList);
    }




    @FXML
    void createEvent(ActionEvent event) {
        { event newEvent = new event(eventTitle.getText(), eventDescription.getText(), eventType.getValue(),
                 eventLocation.getValue(), eventVenue.getText(), totalPrice.getText());
            HelloApplication.events.add(newEvent);
        }
        eventTitle.clear();
        eventDescription.clear();
        eventVenue.clear();
        totalPrice.clear();

        eventType.valueProperty().set(null);
        eventLocation.valueProperty().set(null);

    }




    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    HelloApplication Events;

    @FXML
    void handleReadDetails(ActionEvent event) {

        event events;
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.events.size();i++){
            events =  HelloApplication.events.get(i);
            if(id==events.getId()) {

                eventTitle.setText(events.getEventTitle());
                eventDescription.setText(events.getEventDescription());
                eventType.setValue(events.getEventType());
                eventLocation.setValue(events.getEventLocation());
                eventVenue.setText(events.getEventVenue());
                totalPrice.setText(events.getTotalPrice());
                return;
            }

        }


        }



    @FXML
    void handleUpdateDetails(ActionEvent event) throws IOException {
        event events;
        int id;
        try {
            id = Integer.parseInt(idField.getText());
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.events.size();i++){
            events =  HelloApplication.events.get(i);
            if(id==events.getId()) {
                events.setEventTitle(eventTitle.getText());
                events.setEventDescription(eventDescription.getText());
                events.setEventType(eventType.getValue());
                events.setEventLocation(eventLocation.getValue());
                events.setEventVenue(eventVenue.getText());
                events.setTotalPrice(totalPrice.getText());

                return;
            }

        }

    }

    @FXML
    void eventSummary(ActionEvent event) {
        String result = "";
        for (int i=0; i<HelloApplication.events.size();i++) {
            result += HelloApplication.events.get(i).getId() + " - " + HelloApplication.events.get(i).getEventTitle() + "\n" ;
        }
        eventTextArea.setText(result);
    }


}
