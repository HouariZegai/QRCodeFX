package com.houarizegai.qrcodefx.global;

import com.jfoenix.controls.JFXTextField;

public class FXTools {
    public static void fieldAcceptNumbersOnly(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                field.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }
}
