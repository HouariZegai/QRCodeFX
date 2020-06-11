package com.houarizegai.qrcodefx.global;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.paint.Color;

public class FXTools {
    public static void fieldAcceptNumbersOnly(JFXTextField field) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*"))
                field.setText(newValue.replaceAll("[^\\d]", ""));
        });
    }

    public static String toRGBCode(Color color ) {
        return String.format( "#%02X%02X%02X",
                (int)( color.getRed() * 255 ),
                (int)( color.getGreen() * 255 ),
                (int)( color.getBlue() * 255 ) );
    }
}
