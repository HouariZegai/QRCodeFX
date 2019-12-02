package com.houarizegai.qrcodegenfx.controllers;

import com.houarizegai.qrcodegenfx.App;
import com.houarizegai.qrcodegenfx.engine.QRCodeEngine;
import com.houarizegai.qrcodegenfx.global.FXTools;
import com.houarizegai.qrcodegenfx.global.Utils;
import com.jfoenix.controls.JFXTextField;
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
    private JFXTextField fieldWidth, fieldHeight;

    @FXML
    private ImageView imgQRCode;

    private FileChooser fileChooser;

    // QRCode generated
    private Image genQRCodeImg;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Make fields accept numbers only
        FXTools.fieldAcceptNumbersOnly(fieldWidth);
        FXTools.fieldAcceptNumbersOnly(fieldHeight);

        // Init fields
        fieldWidth.setText("200");
        fieldHeight.setText("200");

        // Init file chooser
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image (*.png)", "*.png ");
        fileChooser.getExtensionFilters().add(extFilter);
    }

    @FXML
    public void onGenerate() {
        genQRCodeImg = QRCodeEngine.qrCodeGen(areaInput.getText(), Integer.parseInt(fieldWidth.getText()), Integer.parseInt(fieldHeight.getText()));
        if(genQRCodeImg != null)
            imgQRCode.setImage(genQRCodeImg);
    }

    @FXML
    public void onExport() {
        if(genQRCodeImg == null)
            return;
        
        // Choose path of save
        File file = fileChooser.showSaveDialog(App.stage);

        // Write in a file
        if (file != null) {
            Utils.writeImage(genQRCodeImg, "png", file);
        }
    }
}
