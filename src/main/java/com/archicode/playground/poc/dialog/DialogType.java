package com.archicode.playground.poc.dialog;

import lombok.Getter;

/**
 * Dialog icon style
 * @author Tomasz Kozlowski (created on 11.04.2019)
 */
@Getter
public enum DialogType {

    INFO("INFO_CIRCLE", "#00a0ff"),
    QUESTION("QUESTION_CIRCLE", "#6fb94a"),
    CONFIRM("CHECK_CIRCLE", "#6FB94A"),
    ERROR("EXCLAMATION_CIRCLE", "#E74141");

    /** Dialog icon name */
    private final String icon;
    /** Dialog icon color */
    private final String color;

    DialogType(String icon, String color) {
        this.icon = icon;
        this.color = color;
    }

}
