package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartStage extends Stage {

    public StartStage() {
        try {
            // Path to the FXML File
            String fxmlDocPath = "/azienda/view/start-view.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
            loader.setController(App.CONTROLLER);
            final Parent root = loader.load();

            final Scene scene = new Scene(root);
            this.setTitle("DBMS Azienda");
            this.setScene(scene);
            this.setMaximized(true);
            this.show();
        } catch (IOException e) {
            App.CONTROLLER.getView().showError(e.getMessage());
        }
    }

    public void closeStage() {
        this.close();
    }
}
