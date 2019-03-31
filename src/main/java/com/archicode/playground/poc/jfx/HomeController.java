package com.archicode.playground.poc.jfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Tomasz Kozlowski (created on 22.03.2019)
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane dashboard;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;

    private void onIconClick(ActionEvent event) {
        System.out.println("You clicked Icon!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Line Chart
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Open");
        series1.getData().add(new XYChart.Data<>("9:00AM", 300));
        series1.getData().add(new XYChart.Data<>("12:00AM", 400));
        series1.getData().add(new XYChart.Data<>("3:00PM", 500));
        series1.getData().add(new XYChart.Data<>("6:00PM", 500));
        series1.getData().add(new XYChart.Data<>("9:00PM", 600));
        series1.getData().add(new XYChart.Data<>("12:00PM", 600));
        series1.getData().add(new XYChart.Data<>("3:00AM", 700));
        series1.getData().add(new XYChart.Data<>("6:00AM", 700));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Click");
        series2.getData().add(new XYChart.Data<>("9:00AM", 50));
        series2.getData().add(new XYChart.Data<>("12:00AM", 100));
        series2.getData().add(new XYChart.Data<>("3:00PM", 150));
        series2.getData().add(new XYChart.Data<>("6:00PM", 150));
        series2.getData().add(new XYChart.Data<>("9:00PM", 250));
        series2.getData().add(new XYChart.Data<>("12:00PM", 300));
        series2.getData().add(new XYChart.Data<>("3:00AM", 350));
        series2.getData().add(new XYChart.Data<>("6:00AM", 400));

        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Click second time");
        series3.getData().add(new XYChart.Data<>("9:00AM", 0));
        series3.getData().add(new XYChart.Data<>("12:00AM", 100));
        series3.getData().add(new XYChart.Data<>("3:00PM", 50));
        series3.getData().add(new XYChart.Data<>("6:00PM", 100));
        series3.getData().add(new XYChart.Data<>("9:00PM", 200));
        series3.getData().add(new XYChart.Data<>("12:00PM", 300));
        series3.getData().add(new XYChart.Data<>("3:00AM", 300));
        series3.getData().add(new XYChart.Data<>("6:00AM", 350));

        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);

        // Pie Chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Open", 40),
                new PieChart.Data("Bounce", 20),
                new PieChart.Data("Unsubscribe", 40)
        );
        pieChart.setData(pieChartData);

        // Bar Chart
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Tesla Model S");
        series4.getData().add(new XYChart.Data<>("Jan", 550));
        series4.getData().add(new XYChart.Data<>("Feb", 450));
        series4.getData().add(new XYChart.Data<>("Mar", 320));
        series4.getData().add(new XYChart.Data<>("Apr", 780));
        series4.getData().add(new XYChart.Data<>("Mai", 550));
        series4.getData().add(new XYChart.Data<>("Jun", 450));
        series4.getData().add(new XYChart.Data<>("Jul", 350));
        series4.getData().add(new XYChart.Data<>("Aug", 450));
        series4.getData().add(new XYChart.Data<>("Sep", 550));
        series4.getData().add(new XYChart.Data<>("Oct", 600));
        series4.getData().add(new XYChart.Data<>("Nov", 750));
        series4.getData().add(new XYChart.Data<>("Dec", 890));

        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
        series5.setName("BMW 5 Series");
        series5.getData().add(new XYChart.Data<>("Jan", 400));
        series5.getData().add(new XYChart.Data<>("Feb", 250));
        series5.getData().add(new XYChart.Data<>("Mar", 310));
        series5.getData().add(new XYChart.Data<>("Apr", 580));
        series5.getData().add(new XYChart.Data<>("Mai", 460));
        series5.getData().add(new XYChart.Data<>("Jun", 360));
        series5.getData().add(new XYChart.Data<>("Jul", 300));
        series5.getData().add(new XYChart.Data<>("Aug", 380));
        series5.getData().add(new XYChart.Data<>("Sep", 380));
        series5.getData().add(new XYChart.Data<>("Oct", 400));
        series5.getData().add(new XYChart.Data<>("Nov", 620));
        series5.getData().add(new XYChart.Data<>("Dec", 700));

        barChart.getData().add(series4);
        barChart.getData().add(series5);

    }

}
