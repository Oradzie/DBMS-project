package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import azienda.data.DettaglioOrdine;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AggiungiAlCarrelloController {
        private static final Controller controller = App.CONTROLLER;

        @FXML
        private TextField codiceProdotto;
        @FXML
        private TextField quantita;

        @FXML
        public void toggleAggiuntaCarrello() {
                Pair<Boolean, String> result = DettaglioOrdine.DAO.addDettaglio(controller.getModel().getConnection(),
                                controller.getModel().getLastOrderAdded(), Integer.valueOf(quantita.getText()),
                                controller.getModel().getLastLineaAdded(), codiceProdotto.getText());
                controller.getView()
                                .showError(result.second());
                if (result.first())
                        controller.getModel().setLastLineaAdded(controller.getModel().getLastLineaAdded() + 1);
        }

        @FXML
        public void toggleTerminaOrdine() {
                controller.toggleAggiungiOrdine();
        }
}
