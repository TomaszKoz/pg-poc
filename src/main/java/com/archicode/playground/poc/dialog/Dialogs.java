package com.archicode.playground.poc.dialog;

import com.archicode.playground.poc.css.StyleClass;
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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class provides functionality for generating application dialogs.
 * @author Tomasz Kozlowski (created on 10.04.2019)
 */
@SuppressWarnings("unused")
public class Dialogs {

    /** Creates and shows custom dialog with no action buttons */
    public static void showDialog(Pane parent, String message) {
        showDialog(parent, null, message, null, true, Collections.emptyMap());
    }

    /** Creates and shows custom dialog with one action button */
    public static void showDialog(Pane parent, String title, String message, DialogType dialogType, String buttonName1, Action buttonAction1) {
        Map<String, Action> actions = new LinkedHashMap<>(1);
        actions.put(buttonName1, buttonAction1);
        showDialog(parent, title, message, dialogType, false, actions);
    }

    /** Creates and shows custom dialog with two action buttons */
    public static void showDialog(Pane parent, String title, String message, DialogType dialogType, String buttonName1, Action buttonAction1,
                                  String buttonName2, Action buttonAction2) {
        Map<String, Action> actions = new LinkedHashMap<>(2);
        actions.put(buttonName1, buttonAction1);
        actions.put(buttonName2, buttonAction2);
        showDialog(parent, title, message, dialogType, false, actions);
    }

    /** Creates and shows custom dialog with three action buttons */
    public static void showDialog(Pane parent, String title, String message, DialogType dialogType, String buttonName1, Action buttonAction1,
                                  String buttonName2, Action buttonAction2, String buttonName3, Action buttonAction3) {
        Map<String, Action> actions = new LinkedHashMap<>(3);
        actions.put(buttonName1, buttonAction1);
        actions.put(buttonName2, buttonAction2);
        actions.put(buttonName3, buttonAction3);
        showDialog(parent, title, message, dialogType, false, actions);
    }

    /** Creates and shows custom dialog */
    private static void showDialog(Pane parent, String title, String message, DialogType dialogType, boolean overlayClose, Map<String, Action> actions) {
        // Dialog
        JFXAlert dialog = new JFXAlert((Stage) parent.getScene().getWindow());
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setOverlayClose(overlayClose);

        // Header
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
        if (title != null) {
            Label titleLabel = new Label(title);
            titleLabel.getStyleClass().add(StyleClass.DIALOG_TITLE);
            header.getChildren().add(titleLabel);
        }

        // Dialog content
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(header);
        content.setBody(new Label(message));

        // Action buttons
        HBox buttons = new HBox();
        for (Map.Entry<String, Action> action : actions.entrySet()) {
            buttons.getChildren().add(
                createButton(dialog, action.getKey(), action.getValue())
            );
        }
        content.setActions(buttons);

        // Set content and show dialog
        dialog.setContent(content);
        dialog.show();
    }

    /** Creates dialog action button */
    private static JFXButton createButton(JFXAlert dialog, String name, Action action) {
        JFXButton button = new JFXButton(name);
        button.getStyleClass().add(StyleClass.DIALOG_BUTTON);
        button.setButtonType(JFXButton.ButtonType.RAISED);
        button.setOnAction(event -> {
            dialog.hideWithAnimation();
            action.run();
        });
        return button;
    }

}
