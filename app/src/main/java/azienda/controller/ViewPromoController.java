package azienda.controller;

import java.util.List;

import azienda.App;
import azienda.data.VenditaPromozionale;
import azienda.data.VenditaPromozionaleRaw;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPromoController {

    @FXML
    private TableView<VenditaPromozionaleRaw> tableView;
    @FXML
    private TableColumn<VenditaPromozionaleRaw, String> dataFine;
    @FXML
    private TableColumn<VenditaPromozionaleRaw, String> dataInizio;
    @FXML
    private TableColumn<VenditaPromozionaleRaw, String> percentualeSconto;
    @FXML
    private TableColumn<VenditaPromozionaleRaw, String> codicePromo;

    @FXML
    private void loadPromotions() {
        final List<VenditaPromozionaleRaw> promozioni = App.CONTROLLER.getModel().getPromozioni();
        dataInizio.setCellValueFactory(new PropertyValueFactory<>("DataInizio"));
        dataFine.setCellValueFactory(new PropertyValueFactory<>("DataFine"));
        percentualeSconto.setCellValueFactory(new PropertyValueFactory<>("PercentualeSconto"));
        codicePromo.setCellValueFactory(new PropertyValueFactory<>("CodicePromo"));

        // Simulate data loading
        ObservableList<VenditaPromozionaleRaw> data = FXCollections.observableArrayList(
                promozioni);
        tableView.setItems(data);
    }
}
