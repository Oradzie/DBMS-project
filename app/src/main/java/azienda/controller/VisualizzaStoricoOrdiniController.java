package azienda.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import azienda.data.StoricoOrdiniRow;
import azienda.App;

import java.util.List;

public class VisualizzaStoricoOrdiniController {

    @FXML
    private TableView<StoricoOrdiniRow> storicoOrdiniTable;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codiceOrdineColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> dataOrdineColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> indirizzoDestinatarioColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codiceScontoColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, Double> percentualeScontoUtenteColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, Double> percentualeScontoPromoColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codiceProdottoColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> specificheColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, Integer> quantitaColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> numeroSerialeColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codiceLottoColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codPaccoColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> codiceFiscaleColumn;
    @FXML
    private TableColumn<StoricoOrdiniRow, String> nomeCompletoColumn;

    @FXML
    public void initialize() {
        List<StoricoOrdiniRow> orders = App.CONTROLLER.getModel().getStoricoOrdini();
        ObservableList<StoricoOrdiniRow> ordersList = FXCollections.observableArrayList(orders);
        codiceOrdineColumn.setCellValueFactory(new PropertyValueFactory<>("codiceOrdine"));
        dataOrdineColumn.setCellValueFactory(new PropertyValueFactory<>("dataOrdine"));
        indirizzoDestinatarioColumn.setCellValueFactory(new PropertyValueFactory<>("indirizzoDestinatario"));
        codiceScontoColumn.setCellValueFactory(new PropertyValueFactory<>("codiceSconto"));
        percentualeScontoUtenteColumn.setCellValueFactory(new PropertyValueFactory<>("percentualeScontoUtente"));
        percentualeScontoPromoColumn.setCellValueFactory(new PropertyValueFactory<>("percentualeScontoPromo"));
        codiceProdottoColumn.setCellValueFactory(new PropertyValueFactory<>("codiceProdotto"));
        specificheColumn.setCellValueFactory(new PropertyValueFactory<>("specifiche"));
        quantitaColumn.setCellValueFactory(new PropertyValueFactory<>("quantita"));
        numeroSerialeColumn.setCellValueFactory(new PropertyValueFactory<>("numeroSeriale"));
        codiceLottoColumn.setCellValueFactory(new PropertyValueFactory<>("codiceLotto"));
        codPaccoColumn.setCellValueFactory(new PropertyValueFactory<>("codPacco"));
        codiceFiscaleColumn.setCellValueFactory(new PropertyValueFactory<>("codiceFiscale"));
        nomeCompletoColumn.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        storicoOrdiniTable.setItems(ordersList);
    }
}
