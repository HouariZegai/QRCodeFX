package com.houarizegai.qrcodegenfx.global;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class FXTools {
    public static void fieldAcceptNumbersOnly(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                field.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }
}
