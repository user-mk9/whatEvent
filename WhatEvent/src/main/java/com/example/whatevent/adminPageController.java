package com.example.whatevent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class adminPageController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea adminTextArea;

    @FXML
    private TextField emailField;

    @FXML
    void enableDisableBtn(ActionEvent event) {

    }



    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void listAllEventsBtn(ActionEvent event) {
        event events;

        String result = "";

        for (int i=0; i<HelloApplication.events.size();i++){
            events =  HelloApplication.events.get(i);


            result += HelloApplication.events.get(i).getId() + " , " + HelloApplication.events.get(i).getEventTitle() + " , " +
                    HelloApplication.events.get(i).getEventDescription() + " , " + HelloApplication.events.get(i).getEventType() +
                    " , " + HelloApplication.events.get(i).getEventLocation() + " , " + HelloApplication.events.get(i).getEventVenue() +
                    " , " + HelloApplication.events.get(i).getTotalPrice() + "\n" ;


        }
        adminTextArea.setText(result);

    }

    @FXML
    void listAllOrganisers(ActionEvent event) {
        String result = "";
        for (int i=0; i<HelloApplication.users.size();i++) {
            result += HelloApplication.users.get(i).getName() + " - " + HelloApplication.users.get(i).getEmail() + "\n" ;
        }
        adminTextArea.setText(result);
    }


    @FXML
    void listDetails(ActionEvent event) {

        userDetails users;

        String email;

        try{
            email = emailField.getText();
        }
        catch (Exception e){
            return;
        }
        for (int i=0; i<HelloApplication.users.size();i++){
            users = HelloApplication.users.get(i);
            if(email.equals(users.getEmail())){
                adminTextArea.setText(users.getName() + "\n" + users.getEmail() + "\n" + users.getPhone() +
                        "\n" + users.getWebsite());
                return;
            }
        }

    }

    @FXML
    void listEvents(ActionEvent event) {

    }

}
