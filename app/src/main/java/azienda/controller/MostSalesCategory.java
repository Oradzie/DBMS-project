package azienda.controller;

import azienda.App;
import azienda.data.SalesRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MostSalesCategory {

    @FXML
    private TableView<SalesRow> tableView;
    @FXML
    private TableColumn<SalesRow, String> meseColumn;
    @FXML
    private TableColumn<SalesRow, String> categoriaColumn;
    @FXML
    private TableColumn<SalesRow, Integer> venditeColumn;

    @FXML
    public void initialize() {
        final List<SalesRow> statistics = App.CONTROLLER.getModel().getSalesStatistics();
        meseColumn.setCellValueFactory(new PropertyValueFactory<>("Mese"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("NomeProdotto"));
        venditeColumn.setCellValueFactory(new PropertyValueFactory<>("NumeroVendite"));

        // Fill the table with data
        ObservableList<SalesRow> productList = FXCollections.observableArrayList(statistics);
        tableView.setItems(productList);
    }
}
