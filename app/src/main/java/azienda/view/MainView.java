package azienda.view;

import azienda.data.Prodotto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import azienda.App;

import java.io.IOException;
import java.util.List;

import azienda.controller.Controller;

public class MainView extends Application {

    @Override
    public void start(final Stage stage) throws IOException {
        // Path to the FXML File
        String fxmlDocPath = "/azienda/view/start-view.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        loader.setController(App.CONTROLLER);
        Parent root = loader.load();

        
        final Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/azienda/view/style.css")));
        stage.setTitle("DBMS Azienda");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void showError(String s) {
        System.err.println(s);
    }

    public void showProducts(List<Prodotto> products) {
        for (Prodotto product : products) {
            System.out.println(product.getNumeroSeriale());
        }
    }
}