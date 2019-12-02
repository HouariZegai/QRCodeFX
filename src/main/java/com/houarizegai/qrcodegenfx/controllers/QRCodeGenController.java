package com.houarizegai.qrcodegenfx.controllers;

import com.houarizegai.qrcodegenfx.App;
import com.houarizegai.qrcodegenfx.engine.QRCodeEngine;
import com.houarizegai.qrcodegenfx.global.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class QRCodeGenController implements Initializable {

    @FXML
    private TextArea areaInput;

    @FXML
    private ImageView imgQRCode;

    private FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Init file chooser
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image (*.png)", "*.png ");
        fileChooser.getExtensionFilters().add(extFilter);
    }

    @FXML
    public void onGenerate() {
        Image genQRCode = QRCodeEngine.qrCodeGen(areaInput.getText(), 200, 200);
        if(genQRCode != null)
            imgQRCode.setImage(genQRCode);
    }

    @FXML
    public void onExport() {
        // Choose path of save
        File file = fileChooser.showSaveDialog(App.stage);

        // Write in a file
        if (file != null) {
            Utils.writeImage(imgQRCode.getImage(), "png", file);
        }
    }
}
