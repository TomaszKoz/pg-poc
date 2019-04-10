package com.archicode.playground.poc.dialog;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Tomasz Kozlowski (created on 10.04.2019)
 */
public class Dialogs {

    public static void showDialog(Pane parent) {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Label("Example Dialog"));
        content.setBody(new Text("This is an example dialog with some not interesting text..."));

        StackPane stackPane = new StackPane();
//        stackPane.autosize();
        stackPane.setPrefSize(parent.getPrefWidth(), 300);
        JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.CENTER);
        dialog.setPrefSize(300,200);


        JFXButton button = new JFXButton("Accept");
        button.setTextFill(Paint.valueOf("WHITE"));
        button.setStyle("-fx-background-color: #63D8F1");
        button.setPrefSize(120, 40);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setOnAction(e -> {
            dialog.close();
            parent.getChildren().remove(stackPane);
        });
        content.setActions(button);

        // calculate dialog position
//        double positionX = (parent.getWidth() / 2) - (dialog.getPrefWidth() / 2);
//        if (positionX < 0) {
//            positionX = 0;
//        }
//
//        dialog.setLayoutX(positionX);
//        dialog.setLayoutY(300);


        parent.getChildren().addAll(stackPane);
        dialog.show();
    }

    public static void showAlert(Pane parent) {
        JFXAlert alert = new JFXAlert((Stage) parent.getScene().getWindow());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setOverlayClose(false);

        JFXDialogLayout layout = new JFXDialogLayout();
        Label header = new Label("Example Dialog");
        header.setFont(Font.font("30"));
        layout.setHeading(header);
        layout.setBody(new Label("This is an example dialog with some not interesting text..."));

        JFXButton button = new JFXButton("ACCEPT");
        //button.setTextFill(Paint.valueOf("#63D8F1"));
        button.setStyle("-fx-text-fill: #03A9F4; -fx-font-weight: BOLD; -fx-padding: 0.7em 0.8em;");
//        button.setStyle("-fx-background-color: #63D8F1; -fx-text-fill: WHITE; -fx-font-weight: BOLD; -fx-end-margin: 20 20 20 20;");

//        button.setTextFill(Paint.valueOf("WHITE"));
//        button.setStyle("-fx-background-color: #63D8F1");
        button.setPrefSize(120, 40);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setOnAction(event -> alert.hideWithAnimation());
        layout.setActions(button);


        alert.setContent(layout);
        alert.show();
    }

}
