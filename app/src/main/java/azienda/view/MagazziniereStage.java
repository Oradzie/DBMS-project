package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MagazziniereStage extends Stage {
    public MagazziniereStage() {
        try {
            // Path to the FXML File
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/azienda/view/magazziniere-dashboard.fxml"));
            loader.setController(App.CONTROLLER);
            Parent root = loader.load();

            final Scene scene = new Scene(root);
            this.setTitle("DBMS Azienda");
            this.setScene(scene);
            this.setMaximized(true);
            this.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeStage() {
        this.close();
    }
}
