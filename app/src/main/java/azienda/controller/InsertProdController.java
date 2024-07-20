package azienda.controller;

import azienda.App;
import azienda.data.Prodotto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InsertProdController {

    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField NumeroSeriale;
    @FXML
    private TextField CodiceLotto;
    @FXML
    private TextField CodiceProdotto;
    @FXML
    private TextField CodRipiano;

    @FXML
    public void salvaProdotto() {
        controller.getView()
                .showError(Prodotto.DAO.addProduct(controller.getModel().getConnection(), this.NumeroSeriale.getText(),
                        this.CodiceLotto.getText(), this.CodiceProdotto.getText(),
                        this.CodRipiano.getText()));
    }
}
