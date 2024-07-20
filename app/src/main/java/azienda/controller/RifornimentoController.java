package azienda.controller;

import azienda.App;
import azienda.data.Fornitore;
import azienda.data.VersioneProdotto;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.Objects;

public class RifornimentoController {

    @FXML
    private ComboBox<Fornitore> boxFornitore;
    @FXML
    private ComboBox<VersioneProdotto> boxProdotto;
    @FXML
    private TextField quantity;

    public void initialize() {
        // Fill the combobox with data
        boxFornitore.getItems().addAll(App.CONTROLLER.getModel().getFornitori());
        boxProdotto.getItems().addAll(App.CONTROLLER.getModel().getVersioniProdotto());

        quantity.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                quantity.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public void confermaRifornimento() {
        if (Objects.nonNull(boxFornitore.getValue()) && Objects.nonNull(boxProdotto.getValue()) && !quantity.getText().isEmpty()) {
            App.CONTROLLER.getModel().inlotraRichiestaRifornimento(boxFornitore.getValue(), boxProdotto.getValue(), Integer.parseInt(quantity.getText()));
            App.CONTROLLER.getView().showError("Rifornimento effettuato con successo!");
        } else {
            App.CONTROLLER.getView().showError("Errore, compilare tutti i campi!");
        }
    }
}
