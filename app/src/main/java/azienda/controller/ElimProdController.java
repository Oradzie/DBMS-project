package azienda.controller;

import azienda.App;
import azienda.data.Prodotto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ElimProdController {

    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField NumeroSeriale;

    @FXML
    public void eliminaProdotto() {
        controller.getView()
                .showError(
                        Prodotto.DAO.delProduct(controller.getModel().getConnection(), this.NumeroSeriale.getText()));
    }
}
