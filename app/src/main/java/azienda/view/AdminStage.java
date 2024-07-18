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
        // Path to the FXML File
        String fxmlDocPath = "/azienda/view/amministrator-dashboard.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlDocPath));
        loader.setController(App.CONTROLLER);

        String insMagDocPath = "/azienda/view/inserimentoMagazziniere.fxml";
        FXMLLoader insMagLoader = new FXMLLoader(getClass().getResource(insMagDocPath));
        insMagLoader.setController(App.CONTROLLER);

        String catVenDocPath = "/azienda/view/categoria-piu-venduta.fxml";
        FXMLLoader catVenLoader = new FXMLLoader(getClass().getResource(catVenDocPath));
        catVenLoader.setController(App.CONTROLLER);

        String andVenDocPath = "/azienda/view/andamento-vendite.fxml";
        FXMLLoader andVenLoader = new FXMLLoader(getClass().getResource(andVenDocPath));


        try{
            Parent root = loader.load();
            insMagLoader.load();
            catVenLoader.load();
            andVenLoader.load();
            App.CONTROLLER.setSalesController((SalesChartController) andVenLoader.getController());
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
