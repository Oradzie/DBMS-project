package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartStage extends Stage {

    public StartStage() {
        // Path to the FXML File
        String fxmlDocPath = "/azienda/view/start-view.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        loader.setController(App.CONTROLLER);
        try {
            final Parent root = loader.load();

            final Scene scene = new Scene(root);
            scene.getStylesheets().add(String.valueOf(getClass().getResource("/azienda/view/style.css")));
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
