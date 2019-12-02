package com.houarizegai.qrcodegenfx.global;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Utils {

    public static void writeImage(Image image, String formatName, File outputFile)  {
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, formatName, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
