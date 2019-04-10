package com.archicode.playground.poc.jfx;

import com.archicode.playground.poc.notification.NotificationController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Tomasz Kozlowski (created on 22.03.2019)
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane workingPane;

    @FXML
    private AnchorPane dashboard;
    @FXML
    private AnchorPane userProfile;
    @FXML
    private AnchorPane icons;
    @FXML
    private AnchorPane maps;
    @FXML
    private AnchorPane notification;

    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private PieChart pieChart;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Pane settingsPanel;
    @FXML
    private FontAwesomeIconView arrow;
    @FXML
    private ImageView imageView;
    @FXML
    private JFXButton dashboardButton;
    @FXML
    private JFXButton userProfileButton;
    @FXML
    private JFXButton iconsButton;
    @FXML
    private JFXButton mapButton;
    @FXML
    private JFXButton notificationButton;
    private JFXButton activeButton;
    @FXML
    private ImageView background;
    @FXML
    private Pane sidePane;
    @FXML
    private Pane topPane;
    @FXML
    private JFXToggleButton backgroundButton;
    @FXML
    private FontAwesomeIconView dropdownButton;
    @FXML
    private Pane dropdownPane;
    @FXML
    private Circle imageCircle;
    @FXML
    private WebView webView = new WebView();
    @FXML
    private Label titleLabel;

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

        Image image = new Image("/images/faces/face-3.jpg");
        imageCircle.setFill(new ImagePattern(image));
    }

    @FXML
    public void onSettings(MouseEvent event) {
        fadeAnimation(settingsPanel);
    }

    @FXML
    public void onDropdown(MouseEvent event) {
        fadeAnimation(dropdownPane);
    }

    private void fadeAnimation(Node node) {
        boolean isVisible = node.isVisible();
        FadeTransition transition = new FadeTransition(Duration.seconds(0.1), node);
        if (isVisible) {
            transition.setFromValue(1.0);
            transition.setToValue(0.0);
            transition.setOnFinished(v -> node.setVisible(false));
        } else {
            transition.setFromValue(0.0);
            transition.setToValue(1.0);
            node.setVisible(true);
        }
        transition.play();
    }

    @FXML
    public void onImage1(MouseEvent event) {
        background.setImage(new Image("images/sidebar-3.jpg"));
    }

    @FXML
    public void onImage2(MouseEvent event) {
        background.setImage(new Image("images/sidebar-1.jpg"));
    }

    @FXML
    public void onImage3(MouseEvent event) {
        background.setImage(new Image("images/sidebar-2.jpg"));
    }

    @FXML
    public void onImage4(MouseEvent event) {
        background.setImage(new Image("images/sidebar-5.jpg"));
    }

    @FXML
    public void onColor1(MouseEvent event) {
        sidePane.setStyle("-fx-background-color: #252625");
        sidePane.setOpacity(0.8);
        topPane.setStyle("-fx-background-color: #252625");
        topPane.setOpacity(0.75);
    }

    @FXML
    public void onColor2(MouseEvent event) {
        sidePane.setStyle("-fx-background-color: #1fc6ea");
        sidePane.setOpacity(0.8);
        topPane.setStyle("-fx-background-color: #1fc6ea");
        topPane.setOpacity(0.75);
    }

    @FXML
    public void onColor3(MouseEvent event) {
        sidePane.setStyle("-fx-background-color: #87cb16");
        sidePane.setOpacity(0.8);
        topPane.setStyle("-fx-background-color: #87cb16");
        topPane.setOpacity(0.75);
    }

    @FXML
    public void onColor4(MouseEvent event) {
        sidePane.setStyle("-fx-background-color: #ffa534");
        sidePane.setOpacity(0.8);
        topPane.setStyle("-fx-background-color: #ffa534");
        topPane.setOpacity(0.75);
    }

    @FXML
    public void onColor5(MouseEvent event) {
        sidePane.setStyle("-fx-background-color: #9368e9");
        sidePane.setOpacity(0.8);
        topPane.setStyle("-fx-background-color: #9368e9");
        topPane.setOpacity(0.75);
    }

    @FXML
    public void onBackgroundButton(ActionEvent event) {
        if (backgroundButton.isSelected()) {
            background.setVisible(true);
        } else {
            background.setVisible(false);
        }
    }

    @FXML
    private void onMenuButtonExit(MouseEvent event) {
        if (event.getSource() instanceof JFXButton) {
            JFXButton button = (JFXButton) event.getSource();
            if (activeButton != button) {
                button.setStyle("-fx-background-color: #3E3E3E;");
            }
        }
    }

    @FXML
    private void onMenuButtonEnter(MouseEvent event) {
        if (event.getSource() instanceof JFXButton) {
            JFXButton button = (JFXButton) event.getSource();
            if (activeButton != button) {
                button.setStyle("-fx-background-color: #6C6C6C;");
            }
        }
    }

    @FXML
    private void onDashboard(MouseEvent event) {
        setMenuStyle(dashboardButton, dashboard, true);
        setMenuStyle(userProfileButton, userProfile, false);
        setMenuStyle(iconsButton, icons, false);
        setMenuStyle(mapButton, maps, false);
        setMenuStyle(notificationButton, notification, false);
        titleLabel.setText("Dashboard");
    }

    @FXML
    private void onUserProfile(MouseEvent event) {
        setMenuStyle(dashboardButton, dashboard, false);
        setMenuStyle(userProfileButton, userProfile, true);
        setMenuStyle(iconsButton, icons, false);
        setMenuStyle(mapButton, maps, false);
        setMenuStyle(notificationButton, notification, false);
        titleLabel.setText("User Profile");
    }

    @FXML
    private void onIcons(MouseEvent event) {
        setMenuStyle(dashboardButton, dashboard, false);
        setMenuStyle(userProfileButton, userProfile, false);
        setMenuStyle(iconsButton, icons, true);
        setMenuStyle(mapButton, maps, false);
        setMenuStyle(notificationButton, notification, false);
        titleLabel.setText("Icons");
    }

    @FXML
    private void onMaps(MouseEvent event) {
        setMenuStyle(dashboardButton, dashboard, false);
        setMenuStyle(userProfileButton, userProfile, false);
        setMenuStyle(iconsButton, icons, false);
        setMenuStyle(mapButton, maps, true);
        setMenuStyle(notificationButton, notification, false);
        titleLabel.setText("Map");

        WebEngine engine = webView.getEngine();
        URL url = getClass().getResource("/static/map.html");
        engine.load(url.toExternalForm());
    }

    @FXML
    private void onNotification(MouseEvent event) {
        setMenuStyle(dashboardButton, dashboard, false);
        setMenuStyle(userProfileButton, userProfile, false);
        setMenuStyle(iconsButton, icons, false);
        setMenuStyle(mapButton, maps, false);
        setMenuStyle(notificationButton, notification, true);
        titleLabel.setText("Notification");
    }

    private void setMenuStyle(JFXButton button, AnchorPane pane, boolean enabled) {
        pane.setVisible(enabled);
        if (enabled) {
            button.setStyle("-fx-background-color: #7C7C7C;");
            activeButton = button;
        } else {
            button.setStyle("-fx-background-color: #3E3E3E;");
        }
    }

    @FXML
    private void onInfoNotification(MouseEvent event) {
        new NotificationController().showInfo(workingPane, "This is an example of info notification");
    }

    @FXML
    private void onSuccessNotification(MouseEvent event) {
        new NotificationController().showSuccess(workingPane, "This is an example of success notification");
    }

    @FXML
    private void onWarningNotification(MouseEvent event) {
        new NotificationController().showWarning(workingPane, "This is an example of warning notification");
    }

    @FXML
    private void onErrorNotification(MouseEvent event) {
        new NotificationController().showError(workingPane, "This is an example of danger notification");
    }

}
