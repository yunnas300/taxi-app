package com.example.shaitantaxi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private TaxiOrderController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("shaitan_taxi.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        Scene scene = new Scene(root);
        stage.setTitle("Shaitan Taxi");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        controller.cleanup();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
