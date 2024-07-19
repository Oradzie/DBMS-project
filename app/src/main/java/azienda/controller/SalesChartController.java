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
