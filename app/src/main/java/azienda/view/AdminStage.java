package azienda.view;

import azienda.App;
import azienda.controller.SalesChartController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AdminStage extends Stage {
    
    public AdminStage() {
        try {
            // Caricamento dell'FXML dell'amministratore
            FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("/azienda/view/amministrator-dashboard.fxml"));
            adminLoader.setController(App.CONTROLLER);
            Parent adminRoot = adminLoader.load();

            // Caricamento dell'FXML dell'inserimento magazziniere
            FXMLLoader insMagLoader = new FXMLLoader(getClass().getResource("/azienda/view/inserimentoMagazziniere.fxml"));
            insMagLoader.setController(App.CONTROLLER);
            insMagLoader.load();

            // Caricamento dell'FXML della categoria più venduta
            FXMLLoader catVenLoader = new FXMLLoader(getClass().getResource("/azienda/view/categoria-piu-venduta.fxml"));
            catVenLoader.setController(App.CONTROLLER);
            catVenLoader.load();

            // Caricamento dell'FXML dell'andamento vendite
            FXMLLoader andVenLoader = new FXMLLoader(getClass().getResource("/azienda/view/andamento-vendite.fxml"));
            Parent salesRoot = andVenLoader.load();

            // Impostazione del controller dell'andamento vendite in App.CONTROLLER
            SalesChartController salesChartController = andVenLoader.getController();
            App.CONTROLLER.setSalesController(salesChartController);

            // Creazione della scena principale
            final Scene scene = new Scene(adminRoot);
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
