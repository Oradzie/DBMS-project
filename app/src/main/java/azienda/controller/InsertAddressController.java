package azienda.controller;

import azienda.App;
import azienda.data.Indirizzo;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InsertAddressController {

    private static final Controller controller = App.CONTROLLER;

    @FXML
    private TextField Via;
    @FXML
    private TextField Citta;
    @FXML
    private TextField CAP;
    @FXML
    private TextField NumCivico;

    @FXML
    public void salvaIndirizzo() {
        controller.getView()
                .showError(Indirizzo.DAO.addAddress(controller.getModel().getConnection(), this.Via.getText(),
                        this.Citta.getText(), this.CAP.getText(),
                        this.NumCivico.getText()));
    }
}
