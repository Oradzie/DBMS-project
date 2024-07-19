package azienda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.*;
import azienda.App;
import azienda.data.Magazziniere;
import azienda.data.MyTableRow;


public class MagazzinieriStatisticheController {

    @FXML
    private TableView<MyTableRow> tableView;
    @FXML
    private TableColumn<MyTableRow, String> codiceFiscaleColumn;
    @FXML
    private TableColumn<MyTableRow, String> cognomeColumn;
    @FXML
    private TableColumn<MyTableRow, String> nomeColumn;
    @FXML
    private TableColumn<MyTableRow, String> codiceDipendenteColumn;
    @FXML
    private TableColumn<MyTableRow, Integer> numeroPacchiPreparatiColumn;

    @FXML
    public void showStatistics(){
        final List<MyTableRow> statistics = App.CONTROLLER.getModel().getWarehouseStatistics();
        codiceFiscaleColumn.setCellValueFactory(new PropertyValueFactory<>("codiceFiscale"));
        cognomeColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        codiceDipendenteColumn.setCellValueFactory(new PropertyValueFactory<>("codiceDipendente"));
        numeroPacchiPreparatiColumn.setCellValueFactory(new PropertyValueFactory<>("numeroPacchiPreparati"));
        // Fill the table with data
        ObservableList<MyTableRow> productList = FXCollections.observableArrayList(
            statistics
        );
        tableView.setItems(productList);
        
    }

}
