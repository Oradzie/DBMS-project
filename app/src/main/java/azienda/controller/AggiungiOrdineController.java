package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import azienda.data.Ordine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class AggiungiOrdineController {
    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField indirizzoDestinatario;
    @FXML
    private TextField codiceSconto;
    @FXML
    private TextField codicePromo;
    @FXML
    private VBox aggiungiAlCarrelloPane;

    @FXML
    public void toggleConfermaOrdine() {
        Pair<String, String> result = Ordine.DAO.addOrdine(controller.getModel().getConnection(), LocalDate.now(),
                this.indirizzoDestinatario.getText(),
                this.codiceSconto.getText(),
                this.codicePromo.getText(), App.CONTROLLER.getModel().getCurrentUser());
        controller.getView()
                .showError(result.second());
        controller.getModel().setLastOrderAdded(result.first());

        controller.toggleConcludiOrdine();
    }
}
