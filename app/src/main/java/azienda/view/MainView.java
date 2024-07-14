package azienda.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import azienda.controller.Controller;

public class MainView extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void setController(final Controller controller) {
       this.controller = controller;
    }
}