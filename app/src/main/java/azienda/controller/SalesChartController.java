package azienda.controller;

import azienda.commons.Pair;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class SalesChartController {

    @FXML
    private LineChart<String, Number> salesChart;

    @FXML
    public void initialize(final Pair<String, Integer> salesData) {
        System.out.println("Sales Data: " + salesData);
        // Create a series for sales data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Sales");

        // Example sales data
        series.getData().add(new XYChart.Data<>("Gennaio", 200));
        series.getData().add(new XYChart.Data<>("Febbraio", 150));
        series.getData().add(new XYChart.Data<>("Marzo", 300));
        series.getData().add(new XYChart.Data<>("Aprile", 250));
        series.getData().add(new XYChart.Data<>("Maggio", 400));
        series.getData().add(new XYChart.Data<>("Giugno", 350));
        series.getData().add(new XYChart.Data<>("Luglio", 500));
        series.getData().add(new XYChart.Data<>("Agosto", 450));
        series.getData().add(new XYChart.Data<>("Settembre", 600));
        series.getData().add(new XYChart.Data<>("Ottobre", 550));
        series.getData().add(new XYChart.Data<>("Novembre", 700));
        series.getData().add(new XYChart.Data<>("Dicembre", 650));

        // Add series to chart
        salesChart.getData().add(series);
    }
}
