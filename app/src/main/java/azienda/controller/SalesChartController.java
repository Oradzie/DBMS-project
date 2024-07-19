package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.List;

public class SalesChartController {

    @FXML
    private LineChart<String, Number> salesChart;
    private final List<Pair<String, Integer>> salesData;

    public SalesChartController() {
        System.out.println("SalesChartController created");
        this.salesData = App.CONTROLLER.getModel().getMonthlySales();
    }

    @FXML
    public void initialize() {
        System.out.println(this.salesData);
        // Create a series for sales data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Sales");

        for (Pair<String, Integer> pair : this.salesData) {
            series.getData().add(new XYChart.Data<>(pair.first(), pair.second()));
        }

        // Add series to chart
        salesChart.getData().add(series);
    }
}
