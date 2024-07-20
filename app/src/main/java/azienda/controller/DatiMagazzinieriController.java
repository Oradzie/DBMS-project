package azienda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import azienda.App;
import azienda.data.Magazziniere;
import azienda.data.MagazziniereRow;
import azienda.data.MyTableRow;
import java.util.*;

public class DatiMagazzinieriController {

    @FXML
    private TableView<MagazziniereRow> tableView;
    @FXML
    private TableColumn<MagazziniereRow, String> codiceDipendenteColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> cognomeColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> nomeColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> telefonoColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> ibanColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> viaColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> capColumn;
    @FXML
    private TableColumn<MagazziniereRow, String> numCivicoColumn;

    @FXML
    private void initialize() {
        final List<MagazziniereRow> datiMagazzinieri = App.CONTROLLER.getModel().getDatiMagazzinieri();
        codiceDipendenteColumn.setCellValueFactory(new PropertyValueFactory<>("codiceDipendente"));
        cognomeColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        ibanColumn.setCellValueFactory(new PropertyValueFactory<>("iban"));
        viaColumn.setCellValueFactory(new PropertyValueFactory<>("via"));
        capColumn.setCellValueFactory(new PropertyValueFactory<>("cap"));
        numCivicoColumn.setCellValueFactory(new PropertyValueFactory<>("numCivico"));
        // Simulate data loading
        ObservableList<MagazziniereRow> data = FXCollections.observableArrayList(
                datiMagazzinieri
        );
        tableView.setItems(data);
    }
}
