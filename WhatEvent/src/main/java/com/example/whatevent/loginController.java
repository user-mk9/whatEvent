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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextArea feedbackTextArea;

    @FXML
    private TextField sPassword;

    @FXML
    private TextField sUsername;

    @FXML
    void handleClearFields(ActionEvent event) {
       sUsername.clear();
       sPassword.clear();
       feedbackTextArea.setText("");
    }

    @FXML
    void handlelogin(ActionEvent event) throws IOException {
        System.out.println("Name: "+sUsername.getText() + " Password: " + sPassword.getText());

        userDetails user;

        if (sUsername.getText().equals("admin") && sPassword.getText().equals("admin")) {
            feedbackTextArea. setText ("LOGIN SUCCESSFUL!");
            root = FXMLLoader.load(getClass().getResource("adminPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


        for(int i=0; i<HelloApplication.users.size();i++){
            user = HelloApplication.users.get(i);
            System.out.println(user.getName()+"| : |"+user.getPassword()+"|");
            if(user.getName().equals(sUsername.getText()) && user.getPassword().equals(sPassword.getText())){

                try {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("organiser.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 620, 440);
                    stage.setTitle("My Application");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
           else {
                feedbackTextArea.setText("Unsuccessful Login- try again!");
                sPassword.clear();
            }
            }
        }





    @FXML
    void switchToHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
