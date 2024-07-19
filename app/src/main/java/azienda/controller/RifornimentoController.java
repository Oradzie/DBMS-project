package azienda.controller;

import azienda.App;
import azienda.data.Fornitore;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class RifornimentoController {

    @FXML
    private ComboBox<Fornitore> boxFornitore;

    public void initialize() {
        // Fill the combobox with data
        boxFornitore.getItems().addAll(App.CONTROLLER.getModel().getFornitori());
    }
}
