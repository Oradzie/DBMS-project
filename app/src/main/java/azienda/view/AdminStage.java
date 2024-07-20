package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminStage extends Stage {
    
    public AdminStage() {
        try {
            // Caricamento dell'FXML dell'amministratore
            FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("/azienda/view/amministrator-dashboard.fxml"));
            adminLoader.setController(App.CONTROLLER);
            Parent adminRoot = adminLoader.load();

            // Creazione della scena principale
            final Scene scene = new Scene(adminRoot);
            this.setTitle("DBMS Azienda");
            this.setScene(scene);
            this.setMaximized(true);
            this.show();
        } catch(IOException e){
            App.CONTROLLER.getView().showError(e.getMessage());
        }
    }

    public void closeStage() {
        this.close();
    }
}
