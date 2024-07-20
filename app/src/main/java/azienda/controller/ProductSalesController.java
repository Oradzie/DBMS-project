package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import java.util.List;

public class ProductSalesController {

    @FXML
    private BarChart<String, Number> productSalesChart;

    @FXML
    public void initialize() {
        final List<Pair<String, Integer>> salesData = App.CONTROLLER.getModel().getProductSales();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Vendite per Prodotto");

        for (Pair<String, Integer> pair : salesData) {
            series.getData().add(new XYChart.Data<>(pair.first(), pair.second()));
        }

        this.productSalesChart.getData().add(series);
    }
}
