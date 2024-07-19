package azienda.controller;

import azienda.App;
import azienda.commons.Pair;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SalesChartController {

    @FXML
    private LineChart<String, Number> salesChart;

    @FXML
    public void showChart(ActionEvent actionEvent) {
        final List<Pair<String, Integer>> salesData = App.CONTROLLER.getModel().getMonthlySales();
        System.out.println(salesData);
        // Create a series for sales data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Sales");

        for (Pair<String, Integer> pair : salesData) {
            series.getData().add(new XYChart.Data<>(pair.first(), pair.second()));
        }

        // Add series to chart
        salesChart.getData().add(series);
    }
}
