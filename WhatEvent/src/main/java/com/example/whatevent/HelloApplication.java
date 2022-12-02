package com.example.whatevent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {
    public static ArrayList<userDetails> users;
    public static ArrayList<event> events;


    public HelloApplication(){


        events= new ArrayList<>();
        users=new ArrayList<>();
        popData();
        popDataUsers();


    }

    private void popData() {
        events.add(new event("Shakers","Hip Hop", "Concert", "Dublin",
                "O2 Arena", "25"));
        events.add(new event("RocknRoll","Rock", "Concert", "Dublin",
                "New Arena", "16"));
        events.add(new event("Romeo & Juliet","Theatre", "Movie", "Kildare",
                "O2 Arena", "40"));
        events.add(new event("Bingo","Games", "Games-Night", "Carlow",
                "Hall", "10"));
        events.add(new event("Bee","Theatre", "Drive-thru", "Waterford",
                "Cinema", "20"));

    }

    private void popDataUsers() {
        //users.add(new userDetails("mk","123", "mk@.ie", "123", "0826261921","www.mk321.ie"));
    }


    public String getEventsDetails(int eventId){
        int i =0;

        while(i<events.size()){

            if(events.get(i).getId()== eventId){
                return events.get(i).toString();
            }
            i++;
        }
        return "Id, Title, Type, Area";
    }





    @Override
    public void start(Stage stage) {


        try {

            Parent root = FXMLLoader.load(getClass().getResource("whatEventHomePage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        launch();
    }


}

