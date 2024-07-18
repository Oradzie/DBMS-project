package azienda.view;

import azienda.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminStage extends Stage {
    
    public AdminStage() {
        // Path to the FXML File
        String fxmlDocPath = "/azienda/view/amministrator-dashboard.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        loader.setController(App.CONTROLLER);

        String insMagDocPath = "/azienda/view/inserimentoMagazziniere.fxml";
        FXMLLoader insMagLoader = new FXMLLoader(getClass().getResource(insMagDocPath));
        insMagLoader.setController(App.CONTROLLER);

        String catVenDocPath = "/azienda/view/categoria-più-venduta.fxml";
        FXMLLoader catVenLoader = new FXMLLoader(getClass().getResource(catVenDocPath));

        try{
            Parent root = loader.load();
            insMagLoader.load();
            catVenLoader.load();
            final Scene scene = new Scene(root);
            this.setTitle("DBMS Azienda");
            this.setScene(scene);
            this.setMaximized(true);
            this.show();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeStage() {
        this.close();
    }

}
