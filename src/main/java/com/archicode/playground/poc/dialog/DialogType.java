package com.archicode.playground.poc.dialog;

import lombok.Getter;

/**
 * Dialog icon style
 * @author Tomasz Kozlowski (created on 11.04.2019)
 */
@Getter
public enum DialogType {

    INFO("INFO_CIRCLE", "#5BC0DE"),
    QUESTION("QUESTION_CIRCLE", "#5CB85C"),
    CONFIRM("CHECK_CIRCLE", "#5CB85C"),
    ERROR("EXCLAMATION_CIRCLE", "#D9534F");

    /** Dialog icon name */
    private final String icon;
    /** Dialog icon color */
    private final String color;

    DialogType(String icon, String color) {
        this.icon = icon;
        this.color = color;
    }

}
