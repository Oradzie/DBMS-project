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

        String subDocPath = "/azienda/view/inserimentoMagazziniere.fxml";
        FXMLLoader subLoader = new FXMLLoader(getClass().getResource(subDocPath));
        subLoader.setController(App.CONTROLLER);
        try{
            Parent root = loader.load();
            subLoader.load();
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
