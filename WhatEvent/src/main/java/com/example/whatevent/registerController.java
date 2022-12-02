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

public class registerController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField confPasswordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField socM1Field;

    @FXML
    private TextField socM2Field;

    @FXML
    private TextField websiteField;

    @FXML
    private TextArea regFeedback;


    @FXML
    void exitToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleCreateAccount(ActionEvent event) {
        // In case the Username and Password fields are left blank then display the error message
        if (emailField.getText().isBlank() || nameField.getText().isBlank() || passwordField.getText().isBlank() || confPasswordField.getText().isBlank() || phoneField.getText().isBlank() || websiteField.getText().isBlank()) {


// When the username and password are blank
            if (emailField.getText().isBlank() || nameField.getText().isBlank() || passwordField.getText().isBlank() || confPasswordField.getText().isBlank() || phoneField.getText().isBlank() || websiteField.getText().isBlank()) {
                regFeedback.setText("The Login fields are required!");
            }
        } else // Check if password is less than four characters, if so display error message
            if (passwordField.getText().length() > 5 || confPasswordField.getText().length() > 5  ) {
                regFeedback.setText("The Password can't be more than 4 characters!");

            }else // Check if name is less than four characters, if so display error message
                if (nameField.getText().length() > 30) {
                    regFeedback.setText("The name can't be more than 30 characters!");

                } else
                    if (phoneField.getText().length() < 9) {
                        regFeedback.setText("The phone number can't be less than 9 digits!");
                    }

// If all login details are entered as required then display success message
            else if( passwordField.getText().equals(confPasswordField.getText())) { //All good

                //Create a new RegisteredUser object and add it to the users ArrayList
                userDetails newUser = new userDetails(nameField.getText(), passwordField.getText(), emailField.getText(), confPasswordField.getText(), phoneField.getText(), websiteField.getText());
                HelloApplication.users.add(newUser);
                regFeedback.setText("Successful Organiser Created");


            }


//        if (emailField.getText().isBlank() || nameField.getText().isBlank() || passwordField.getText().isBlank() || confPasswordField.getText().isBlank()) {
//            System.out.println("Enter Fields");
//
//        }
//        if(passwordField.getText().equals(confPasswordField.getText())){ //All good
            //Create a new RegisteredUser object and add it to the users ArrayList
//            userDetails newUser =new userDetails(nameField.getText(),passwordField.getText(),emailField.getText(), confPasswordField.getText(), phoneField.getText(), websiteField.getText());
//            HelloApplication.users.add(newUser);
         //   LoginRegisterApp.logged_In_User=name.getText();
//
//        }try {
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("whatEventHomePage.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 620, 440);
//            stage.setTitle("My Application");
//            stage.setScene(scene);
//            stage.show();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    // else{
    //feedback.setText("Password and Confirmed Password do Not match");
}