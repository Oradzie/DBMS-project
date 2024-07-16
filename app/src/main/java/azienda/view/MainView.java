package azienda.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import azienda.controller.Controller;

public class MainView extends Application {

    private Controller controller;

    @Override
    public void start(final Stage stage) throws IOException {
        // Path to the FXML File
        String fxmlDocPath = "/azienda/view/start-view.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        Parent root = loader.load();

        final Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/azienda/view/style.css")));
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void setController(final Controller controller) {
        this.controller = controller;
    }

}