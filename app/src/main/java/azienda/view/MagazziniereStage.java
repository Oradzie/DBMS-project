package azienda.view;

import azienda.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MagazziniereStage extends Stage {
    public MagazziniereStage() {
        try {
            // Path to the FXML File
            String fxmlDocPath = "/azienda/view/magazziniere-dashboard.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
            loader.setController(App.CONTROLLER);
            Parent root = loader.load();

            String insProdPath = "/azienda/view/inserimentoProdotto.fxml";
            FXMLLoader insProdLoader = new FXMLLoader(getClass().getResource(insProdPath));
            insProdLoader.setController(App.CONTROLLER);
            insProdLoader.load();

            String elimProdPath = "/azienda/view/eliminazioneProdotto.fxml";
            FXMLLoader elimProdLoader = new FXMLLoader(getClass().getResource(elimProdPath));
            elimProdLoader.setController(App.CONTROLLER);
            elimProdLoader.load();

            String visQProdPath = "/azienda/view/VisualizzaQuantitaProdotto.fxml";
            FXMLLoader visQProdLoader = new FXMLLoader(getClass().getResource(visQProdPath));
            visQProdLoader.setController(App.CONTROLLER);
            visQProdLoader.load();

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
