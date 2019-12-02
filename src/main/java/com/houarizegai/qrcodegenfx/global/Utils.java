package com.houarizegai.qrcodegenfx.global;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

    public static void writeImage(File outputFile, String imageFormat, BitMatrix bitMatrix)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
            fileOutputStream.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
