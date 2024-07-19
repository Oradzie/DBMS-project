package azienda.view;

import azienda.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UtenteStage extends Stage {
    public UtenteStage() {
        try {
            // Path to the FXML File
            String fxmlDocPath = "/azienda/view/utente-dashboard.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
            loader.setController(App.CONTROLLER);
            Parent root = loader.load();

            String insIndPath = "/azienda/view/inserimentoIndirizzo.fxml";
            FXMLLoader insIndLoader = new FXMLLoader(getClass().getResource(insIndPath));
            // insIndLoader.setController(App.CONTROLLER);
            insIndLoader.load();

            String visProdPath = "/azienda/view/visualizzaProdottiDisponibili.fxml";
            FXMLLoader visProdLoader = new FXMLLoader(getClass().getResource(visProdPath));
            // insIndLoader.setController(App.CONTROLLER);
            visProdLoader.load();

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
