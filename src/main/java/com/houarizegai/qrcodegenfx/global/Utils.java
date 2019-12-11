package com.houarizegai.qrcodegenfx.global;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Utils {

    public static boolean exportImage(Image image, String formatName, File outputFile)  {
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, formatName, outputFile);
            return true;
        } catch (IOException e) {
            System.out.println("Cannot export image!");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exportText(String text, File outputFile) {
        try {
            PrintWriter out = new PrintWriter(outputFile);
            out.print(text);
            out.close();

            return true;
        } catch(IOException ioe) {
            System.out.println("Cannot export text!");
            ioe.printStackTrace();
            return false;
        }
    }
}
