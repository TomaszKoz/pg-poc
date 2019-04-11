package com.archicode.playground.poc.dialog;

import com.jfoenix.controls.JFXAlert;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Tomasz Kozlowski (created on 10.04.2019)
 */
public class Dialogs {

    public static void showDialog(Pane parent, String title, String message, DialogType dialogType) {
        JFXAlert dialog = new JFXAlert((Stage) parent.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setOverlayClose(false); // todo if there is no buttons than set to true

        // header
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);

        // Icon
        if (dialogType != null) {
            FontAwesomeIconView icon = new FontAwesomeIconView();
            icon.setGlyphName(dialogType.getIcon());
            icon.setSize("30");
            icon.setSmooth(true);
            icon.setFill(Paint.valueOf(dialogType.getColor()));
            header.getChildren().add(icon);
        }

        // Title label
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 20; -fx-padding: 0 0 0 10"); // TODO przeniesc do styli
        header.getChildren().add(titleLabel);

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(header);
        content.setBody(new Label(message));

        // TODO action buttons
        JFXButton button = new JFXButton("ACCEPT");
        //button.setStyle("-fx-text-fill: #03A9F4; -fx-font-weight: BOLD; -fx-padding: 0.7em 0.8em;");
        button.setStyle("-fx-pref-width:120; -fx-pref-height: 40; -fx-text-fill: #00a0ff; -fx-font-weight: BOLD; -fx-padding: 0.7em 0.8em;");
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setOnAction(event -> dialog.hideWithAnimation());
        content.setActions(button);

        dialog.setContent(content);
        dialog.show();
    }

}
