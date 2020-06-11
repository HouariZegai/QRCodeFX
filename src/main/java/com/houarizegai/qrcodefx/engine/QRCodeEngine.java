package com.houarizegai.qrcodefx.engine;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QRCodeEngine {

    public static Image encode(String data, int width, int height, String foregroundColor, String backgroundColor) {
        try {
            BitMatrix byteMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.decode(backgroundColor));
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.decode(foregroundColor));
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            return SwingFXUtils.toFXImage(bufferedImage, null);
        } catch (WriterException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String decode(Image image) {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(SwingFXUtils.fromFXImage(image, null))));

        try {
            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);
            return qrCodeResult.getText();
        } catch(NotFoundException nfe) {
            System.out.println("Not found Exception!");
            return null;
        }

    }
}
