package azienda.controller;

import azienda.App;
import azienda.data.Prodotto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ViewProdController {
    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField CodiceProdotto;

    @FXML
    public void toggleVisualizzaProdotto() {

        controller.getView()
                .showError(
                        Prodotto.DAO.viewProduct(controller.getModel().getConnection(), this.CodiceProdotto.getText()));
    }
}
