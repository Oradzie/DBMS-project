package azienda.controller;

import java.util.List;

import azienda.App;
import azienda.data.VersioneProdotto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProdDispController {

    @FXML
    private TableView<VersioneProdotto> tableView;
    @FXML
    private TableColumn<VersioneProdotto, String> nomeProdotto;
    @FXML
    private TableColumn<VersioneProdotto, String> specifiche;
    @FXML
    private TableColumn<VersioneProdotto, String> disponibilita;
    @FXML
    private TableColumn<VersioneProdotto, String> codiceProdotto;

    @FXML
    private void loadProducts() {
        final List<VersioneProdotto> prodotti = App.CONTROLLER.getModel().getVersioniProdotto();
        nomeProdotto.setCellValueFactory(new PropertyValueFactory<>("NomeProdotto"));
        specifiche.setCellValueFactory(new PropertyValueFactory<>("Specifiche"));
        disponibilita.setCellValueFactory(new PropertyValueFactory<>("Disponibilita"));
        codiceProdotto.setCellValueFactory(new PropertyValueFactory<>("CodiceProdotto"));

        // Simulate data loading
        ObservableList<VersioneProdotto> data = FXCollections.observableArrayList(
                prodotti);
        tableView.setItems(data);
    }
}
