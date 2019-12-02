package com.houarizegai.qrcodegenfx.controllers;

import com.google.zxing.common.BitMatrix;
import com.houarizegai.qrcodegenfx.App;
import com.houarizegai.qrcodegenfx.engine.QRCodeEngine;
import com.houarizegai.qrcodegenfx.global.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import sun.net.www.content.image.png;
import sun.swing.FilePane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class QRCodeGenController implements Initializable {

    @FXML
    private TextArea areaInput;

    private BitMatrix bitMatrix;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onGenerate() {
        bitMatrix = QRCodeEngine.generateMatrix(areaInput.getText(), 300);
    }

    @FXML
    public void onExport() {
        // Choose path of save
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image (*.png)", "*.png ");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(App.stage);

        // Write in a file
        if(file != null) {
            Utils.writeImage(file, "png", bitMatrix);
        }
    }
}
