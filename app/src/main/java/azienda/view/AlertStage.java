package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertStage extends Stage {

    public AlertStage() {
        String fxmlDocPath = "/azienda/view/dialog.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        loader.setController(App.CONTROLLER);
        try{
            Parent root = loader.load();
            final Scene scene = new Scene(root);
            this.setTitle("Error");
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
