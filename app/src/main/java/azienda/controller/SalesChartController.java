package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import java.time.Month;
import java.util.List;

public class SalesChartController {

    @FXML
    private LineChart<String, Number> salesChart;

    @FXML
    public void initialize() {
        final List<Pair<String, Integer>> salesData = App.CONTROLLER.getModel().getMonthlySales();
        // Create a series for sales data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Sales");

        for (Pair<String, Integer> pair : salesData) {
            series.getData().add(new XYChart.Data<>(
                    Month.of(Integer.parseInt(pair.first())).getDisplayName(java.time.format.TextStyle.FULL,
                            java.util.Locale.ITALIAN),
                    pair.second()));
        }

        // Add series to chart
        this.salesChart.getData().add(series);
    }
}
