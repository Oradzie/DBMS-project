package azienda.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class SalesChartController {

    @FXML
    private LineChart<Number, Number> salesChart;

    @FXML
    public void initialize() {
        // Create a series for sales data
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Monthly Sales");

        // Example sales data
        series.getData().add(new XYChart.Data<>(1, 200));
        series.getData().add(new XYChart.Data<>(2, 150));
        series.getData().add(new XYChart.Data<>(3, 300));
        series.getData().add(new XYChart.Data<>(4, 250));
        series.getData().add(new XYChart.Data<>(5, 400));
        series.getData().add(new XYChart.Data<>(6, 350));
        series.getData().add(new XYChart.Data<>(7, 500));
        series.getData().add(new XYChart.Data<>(8, 450));
        series.getData().add(new XYChart.Data<>(9, 600));
        series.getData().add(new XYChart.Data<>(10, 550));
        series.getData().add(new XYChart.Data<>(11, 700));
        series.getData().add(new XYChart.Data<>(12, 650));

        // Add series to chart
        salesChart.getData().add(series);
    }
}
